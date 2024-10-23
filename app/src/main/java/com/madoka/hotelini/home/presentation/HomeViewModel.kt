package com.madoka.hotelini.home.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.madoka.hotelini.common.util.calculateDistance
import com.madoka.hotelini.common.util.calculateDistanceBetween
import com.madoka.hotelini.home.data.repository.HotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelRepository: HotelRepository,
    private val placesClient: PlacesClient
) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    init {
        getNearestHotels(latitude = latitude, longitude = longitude)
    }

    /* fun getNearestHotels(latitude: Double, longitude: Double) {

         _homeUiState.value = _homeUiState.value.copy(
             nearestHotels = hotelRepository
                 .getNearestHotels(latitude, longitude)
                 .cachedIn(viewModelScope)
         )

     }*/
    fun refreshAllData(latitude: Double, longitude: Double) {
        getNearestHotels(latitude, longitude)
    }


    fun getNearestHotels(latitude: Double, longitude: Double) {
        this.latitude = latitude
        this.longitude = longitude

        val nearestHotelsFlow = hotelRepository.getNearestHotels(latitude, longitude)
            .cachedIn(viewModelScope)

        viewModelScope.launch {

            nearestHotelsFlow.collectLatest { pagingData ->
                val hotelNames = mutableListOf<String>()
                pagingData.map { hotel ->
                    hotel.title.substringAfter(". ")
                        .trim()
                        .let { hotelNames.add(it) }!!
                }
                // Now calculate distances
                fetchHotelLatLngAndCalculateDistance(latitude, longitude, hotelNames)
            }
        }

        _homeUiState.value = _homeUiState.value.copy(nearestHotels = nearestHotelsFlow)
    }


    private fun fetchHotelLatLngAndCalculateDistance(
        userLat: Double,
        userLng: Double,
        hotelNames: List<String>
    ) {
        val placeFields = listOf(Place.Field.NAME, Place.Field.LAT_LNG)
        val updatedDistances = mutableMapOf<String, String>()

        for (hotelName in hotelNames) {
            val request = FindAutocompletePredictionsRequest.builder()
                .setQuery(hotelName)
                .build()

            placesClient.findAutocompletePredictions(request)
                .addOnSuccessListener { response ->
                    response.autocompletePredictions.firstOrNull()?.let { prediction ->
                        val placeId = prediction.placeId

                        val fetchPlaceRequest = FetchPlaceRequest.newInstance(placeId, placeFields)
                        placesClient.fetchPlace(fetchPlaceRequest)
                            .addOnSuccessListener { placeResponse ->
                                val place = placeResponse.place
                                val hotelLatLng = place.latLng

                                if (hotelLatLng != null) {
                                    val distance = calculateDistance(
                                        LatLng(userLat, userLng),
                                        LatLng(hotelLatLng.latitude, hotelLatLng.longitude)
                                    )
                                    Timber.d("${place.name} is $distance kilometers away")

                                    updatedDistances[place.name.toString()] = "$distance km"

                                    Timber.d("${place.name} is $distance kilometers away")

                                    // Update the state with distances
                                    _homeUiState.value = _homeUiState.value.copy(
                                        hotelDistances = updatedDistances.toMap()
                                    )

                                }
                            }
                    }
                }
        }

    }
}


/* this.latitude = latitude
 this.longitude = longitude

 viewModelScope.launch {
     try {
         //for purpose of getting distance between
         val nearestHotelsFlow = hotelRepository
             .getNearestHotels(latitude, longitude)
             .cachedIn(viewModelScope)

         nearestHotelsFlow.collectLatest { pagingData ->
             // Use PagingData.map to extract hotel titles
             val hotelNames = mutableListOf<String>()
             pagingData.map { hotel ->
                 hotel.title.substringAfter(". ").trim().let {
                     hotelNames.add(it)
                 } // Extract hotel titles into a list
                 Timber.d("${hotel.title} names to be mappes")
             }
             // Now that you have a list of hotel names, fetch latitudes and longitudes
          val updatedDistances = fetchNearestHotelsLatLngAndCalculateDistance(latitude, longitude, hotelNames)

             _homeUiState.value = _homeUiState.value.copy(
                 nearestHotels = nearestHotelsFlow,
                 hotelDistances = updatedDistances
             )
         }
        // _homeUiState.value = _homeUiState.value.copy(nearestHotels = nearestHotelsFlow)

     } catch (e: Exception) {
         Timber.d("Error fetching nearest hotels: $e")
     }
 }
}

private suspend fun fetchNearestHotelsLatLngAndCalculateDistance(
 userLat: Double,
 userLng: Double,
 hotelNames: List<String>
): Map<String, String> {

 return hotelNames.mapNotNull { hotelName ->

     val place = getPlaceDetails(hotelName)
     place?.let {
         val hotelLatLng = place.latLng
         if (hotelLatLng != null) {
             val distance = calculateDistanceBetween(
                 userLat, userLng,
                 hotelLatLng.latitude,
                 hotelLatLng.longitude
             )
             place.name to "$distance km"
         } else null
     }
 }.toMap()
}


 val updatedDistances = mutableMapOf<String, String>()

 for (hotelName in hotelNames) {
     val request = FindAutocompletePredictionsRequest.builder()
         .setQuery(hotelName)
         .build()

     placesClient.findAutocompletePredictions(request)
         .addOnSuccessListener { response ->
             val placeId = response.autocompletePredictions.firstOrNull()?.placeId
             placeId?.let {
                 val fetchPlaceRequest =
                     FetchPlaceRequest.builder(placeId, placeFields).build()

                 //val fetchPlaceRequest = FetchPlaceRequest.newInstance(placeId, placeFields)
                 placesClient.fetchPlace(fetchPlaceRequest)
                     .addOnSuccessListener { placeResponse ->
                         val place = placeResponse.place
                         val hotelLatLng = place.latLng

                         if (hotelLatLng != null) {
                             val distance = calculateDistanceBetween( //calculateDistance(
//                                        LatLng(userLat, userLng),
//                                        LatLng(hotelLatLng.latitude, hotelLatLng.longitude)
                                 userLat,
                                 userLng,
                                 hotelLatLng.latitude,
                                 hotelLatLng.longitude
                             )
                           //  println("${place.name} is $distance kilometers away")
                             Timber.d("${place.name} is $distance kilometers away")

                             updatedDistances[place.name] = "$distance km"

                             // Update the state with distances
                             _homeUiState.value = _homeUiState.value.copy(
                                 hotelDistances = updatedDistances.toMap()
                             )

                         }
                     }
                     .addOnFailureListener { e ->
                         Timber.d("Error fetching place details: ${e.message}")
                     }
             }


//
//                    response.autocompletePredictions.firstOrNull()?.let { prediction ->
//                        val placeId = prediction.placeId
//
//                        // Fetch place details including latitude and longitude
//                        val fetchPlaceRequest =
//                            FetchPlaceRequest.builder(placeId, placeFields).build()
//
//                        //val fetchPlaceRequest = FetchPlaceRequest.newInstance(placeId, placeFields)
//                        placesClient.fetchPlace(fetchPlaceRequest)
//                            .addOnSuccessListener { placeResponse ->
//                                val place = placeResponse.place
//                                val hotelLatLng = place.latLng
//
//                                if (hotelLatLng != null) {
//                                    val distance = calculateDistance(
//                                        LatLng(userLat, userLng),
//                                        LatLng(hotelLatLng.latitude, hotelLatLng.longitude)
////                                    userLat,
////                                    userLng,
////                                    hotelLatLng.latitude,
////                                    hotelLatLng.longitude
//                                    )
//                                    println("${place.name} is $distance kilometers away")
//                                    Timber.d("${place.name} is $distance kilometers away")
//
//                                    updatedDistances[place.name] = "$distance km"
//
//                                    // Update the state with distances
//                                    _homeUiState.value = _homeUiState.value.copy(
//                                        hotelDistances = updatedDistances.toMap()
//                                    )
//
//                                }
//                            }
//                            .addOnFailureListener { exception ->
//                                Timber.d(
//                                    "RETRIEVING PLACES FAILED",
//                                    "Error fetching place details: ${exception.message}"
//                                )
//                            }
//                    }
//                }
//                    .addOnFailureListener { exception ->
//                        Timber.d(
//                            "RETRIEVING PLACES FAILED",
//                            "Error fetching place details: ${exception.message}"
//                        )
//
//                    }
         }
 } */


/* private suspend fun getPlaceDetails(hotelName: String): Place? {
    return suspendCancellableCoroutine { continuation ->
        val request = FindAutocompletePredictionsRequest.builder()
            .setQuery(hotelName)
            .build()

        placesClient.findAutocompletePredictions(request)
            .addOnSuccessListener { response ->
                val placeId = response.autocompletePredictions.firstOrNull()?.placeId
                val placeFields = listOf(Place.Field.NAME, Place.Field.LAT_LNG)
                if (placeId != null) { val fetchPlaceRequest = FetchPlaceRequest.builder(placeId, placeFields).build()
                    placesClient.fetchPlace(fetchPlaceRequest)
                        .addOnSuccessListener { placeResponse ->
                            continuation.resume(placeResponse.place)
                        }
                        .addOnFailureListener { exception ->
                            continuation.resumeWithException(exception)
                        }
                } else {
                    continuation.resume(null)
                }
            }
            .addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
    } */
//}

/*
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

        //for purpose of getting distance between
        val nearestHotelsFlow = hotelRepository
            .getNearestHotels(latitude, longitude)
            .cachedIn(viewModelScope)

        viewModelScope.launch {
            nearestHotelsFlow.collectLatest { pagingData ->
                // Use PagingData.map to extract hotel titles
                val hotelNames = mutableListOf<String>()
                pagingData.map { hotel ->
                    hotel.title.substringAfter(". ").trim().let {
                        hotelNames.add(it)
                    } // Extract hotel titles into a list
                    Timber.d("${hotel.title} names to be mappes")
                }
                // Now that you have a list of hotel names, fetch latitudes and longitudes
                fetchNearestHotelsLatLngAndCalculateDistance(latitude, longitude, hotelNames)
            }
        }

        _homeUiState.value = homeUiState.value.copy(nearestHotels = nearestHotelsFlow)

        _homeUiState.value = HomeUiState(
            nearestHotels = hotelRepository.getNearestHotels(latitude, longitude)
                .cachedIn(viewModelScope)
        )

    }


    private fun fetchNearestHotelsLatLngAndCalculateDistance(
        userLat: Double,
        userLng: Double,
        hotelNames: List<String>
    ) {
        val placeFields = listOf(Place.Field.NAME, Place.Field.LAT_LNG)

        val updatedDistances = mutableMapOf<String, String>()

        for (hotelName in hotelNames) {
            val request = FindAutocompletePredictionsRequest.builder()
                .setQuery(hotelName)
                .build()

            placesClient.findAutocompletePredictions(request).addOnSuccessListener { response ->
                response.autocompletePredictions.firstOrNull()?.let { prediction ->
                    val placeId = prediction.placeId

                    // Fetch place details including latitude and longitude
                    val fetchPlaceRequest = FetchPlaceRequest.builder(placeId, placeFields).build()

                    //val fetchPlaceRequest = FetchPlaceRequest.newInstance(placeId, placeFields)
                    placesClient.fetchPlace(fetchPlaceRequest)
                        .addOnSuccessListener { placeResponse ->
                            val place = placeResponse.place
                            val hotelLatLng = place.latLng

                            if (hotelLatLng != null) {
                                val distance = calculateDistance(
                                    LatLng(userLat, userLng),
                                    LatLng(hotelLatLng.latitude, hotelLatLng.longitude)
//                                    userLat,
//                                    userLng,
//                                    hotelLatLng.latitude,
//                                    hotelLatLng.longitude
                                )
                                println("${place.name} is $distance kilometers away")
                                Timber.d("${place.name} is $distance kilometers away")

                                updatedDistances[place.name] = "$distance km"

                                // Update the state with distances
                                _homeUiState.value = _homeUiState.value.copy(
                                    hotelDistances = updatedDistances.toMap()
                                )

                            }
                        }
                        .addOnFailureListener { exception ->
                            Timber.d(
                                "RETRIEVING PLACES FAILED",
                                "Error fetching place details: ${exception.message}"
                            )
                        }
                }
            }
                .addOnFailureListener { exception ->
                    Timber.d(
                        "RETRIEVING PLACES FAILED",
                        "Error fetching place details: ${exception.message}"
                    )

                }
        }
    }


    fun refreshAllData(latitude: Double, longitude: Double) {
        getNearestHotels(latitude, longitude)
    }
 */


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