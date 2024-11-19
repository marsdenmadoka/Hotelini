package com.madoka.hotelini.hoteldetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madoka.hotelini.common.util.Resource
import com.madoka.hotelini.favourites.data.local.Favorite
import com.madoka.hotelini.favourites.domain.repository.FavouriteRepository
import com.madoka.hotelini.hoteldetail.data.repository.HotelDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HotelDetailsViewModel @Inject constructor(
    private val repository: HotelDetailsRepository,
    private val favoritesRepository: FavouriteRepository,
) : ViewModel() {
    private val _hotelDetailsUiState = MutableStateFlow(HotelDetailsUiState())
    val hotelDetailsUiState = _hotelDetailsUiState.asStateFlow()

    fun getHotelDetails(hotelId: String) {

        viewModelScope.launch {
            _hotelDetailsUiState.update {
                it.copy(
                    isLoading = true
                )
            }

            when (val result = repository.getHotelDetails(hotelId)) {
                is Resource.Error -> {
                    _hotelDetailsUiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                    Timber.d("error message: ${result.message}")
                }

                is Resource.Success -> {
                    _hotelDetailsUiState.update {
                        it.copy(
                            isLoading = false,
                            hotelDetails = result.data?.data
                        )
                    }
                    Timber.d("details screen data: ${result.message}")
                    Timber.d("details screen data: ${result.data?.data}")
                }

                is Resource.Loading -> {
                    _hotelDetailsUiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                else -> {
                    hotelDetailsUiState
                }
            }
        }
    }

    fun isAFavorite(hotelId: String): Flow<Boolean> {
        return favoritesRepository.isFavorites(hotelId)
    }
    fun insertFavorite(favorite: Favorite) {
        viewModelScope.launch {
            favoritesRepository.insertFavorite(favorite)
        }
    }
    fun deleteFavorite(favorite: Favorite) {
        viewModelScope.launch {
            favoritesRepository.deleteOneFavorite(favorite)
        }
    }
}