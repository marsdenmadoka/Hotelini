package com.madoka.hotelini.hoteldetail.presentation

import com.madoka.hotelini.hoteldetail.domain.model.HotelDetails

data class HotelDetailsUiState(

    val isLoading:Boolean = false,
    val error: String? = null,
    val hotelDetails: HotelDetails? = null
)
