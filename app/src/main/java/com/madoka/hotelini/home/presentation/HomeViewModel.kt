package com.madoka.hotelini.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import com.madoka.hotelini.home.data.repository.HotelRepository
//import com.madoka.hotelini.home.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   // private val restaurantRepository: RestaurantRepository,
    private val hotelRepository: HotelRepository,

) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    // val homeUiState = _homeUiState.asStateFlow()


    init {
      //  getNearestRestaurants()
      //  getNearestHotels(latitude = latitude, longitude = longitude)
    }


//    private fun getNearestRestaurants(
//    ) {
//        _homeUiState.value = HomeUiState(
//            restaurants = restaurantRepository.getRestaurant()
//                .cachedIn(viewModelScope)
//        )
//    }

    fun getNearestHotels(
        latitude: Double, longitude: Double
    ) {
        _homeUiState.update { //change this to value to avoid updates
            it.copy(
                nearestHotels = hotelRepository.getNearestHotels(latitude, longitude)
                    .cachedIn(viewModelScope)
            )
        }

    }


    fun refreshAllData(latitude: Double, longitude: Double) {
        getNearestHotels(latitude, longitude)
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



}