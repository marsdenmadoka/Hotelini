package com.madoka.hotelini.home.data.network.hoteldto

data class Data(
    val currentPage: Int,
    val data: List<HotelDetails>,
    val sortDisclaimer: String
)