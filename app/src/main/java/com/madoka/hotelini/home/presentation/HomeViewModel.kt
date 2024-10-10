package com.madoka.hotelini.home.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.madoka.hotelini.common.util.calculateDistance
import com.madoka.hotelini.home.data.repository.HotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelRepository: HotelRepository,
    private val placesClient: PlacesClient // Inject PlacesClient
) : ViewModel() {


    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0


    init {
        getNearestHotels(latitude = latitude, longitude = longitude)
    }

    fun getNearestHotels(latitude: Double, longitude: Double) {

        this.latitude = latitude
        this.longitude = longitude

        val nearestHotels = hotelRepository
            .getNearestHotels(latitude, longitude)
            .cachedIn(viewModelScope)


        viewModelScope.launch {
            nearestHotels.collectLatest { pagingData ->
                // Use PagingData.map to extract hotel titles
                val hotelNames = mutableListOf<String>()
                pagingData.map { hotel ->
                    hotel.title.let { hotelNames.add(it) } // Extract hotel titles into a list
                }

                // Now that you have a list of hotel names, fetch latitudes and longitudes
                fetchNearestHotelsLatLngandCalculateDistance(latitude, longitude, hotelNames)
            }
        }


        _homeUiState.value = HomeUiState(
            nearestHotels = hotelRepository.getNearestHotels(latitude, longitude)
                .cachedIn(viewModelScope)
        )
    }


    private fun fetchNearestHotelsLatLngandCalculateDistance(
        userLat: Double,
        userLng: Double,
        hotelNames: List<String>
    ) {
        val placeFields = listOf(Place.Field.NAME, Place.Field.LAT_LNG)

        for (hotelName in hotelNames) {
            val request = FindAutocompletePredictionsRequest.builder()
                .setQuery(hotelName)
                .build()

            placesClient.findAutocompletePredictions(request).addOnSuccessListener { response ->
                response.autocompletePredictions.firstOrNull()?.let { prediction ->
                    val placeId = prediction.placeId

                    // Fetch place details including latitude and longitude
                    val fetchPlaceRequest = FetchPlaceRequest.newInstance(placeId, placeFields)
                    placesClient.fetchPlace(fetchPlaceRequest)
                        .addOnSuccessListener { placeResponse ->
                            val place = placeResponse.place
                            val hotelLatLng = place.latLng

                            if (hotelLatLng != null) {
                                val distance = calculateDistance(
                                    userLat,
                                    userLng,
                                    hotelLatLng.latitude,
                                    hotelLatLng.longitude
                                )
                                println("${place.name} is $distance kilometers away")

                            }
                        }
                }
            }
        }
    }


    fun refreshAllData(latitude: Double, longitude: Double) {
        getNearestHotels(latitude, longitude)
    }

}


/* _homeUiState.update {
     it.copy(
         restaurants = restaurantRepository
             .getRestaurant(
                 //latitude,longitude
             )
             .map { pagingData ->
                 pagingData.filter {
                     it.averageRating
                 }
             }
             .cachedIn(viewModelScope)
     )
 } */