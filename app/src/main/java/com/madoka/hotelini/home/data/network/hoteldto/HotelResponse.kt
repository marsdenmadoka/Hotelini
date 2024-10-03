package com.madoka.hotelini.home.data.network.hoteldto

data class HotelResponse(
    val `data`: Data,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)