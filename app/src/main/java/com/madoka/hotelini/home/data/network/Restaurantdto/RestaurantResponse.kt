package com.madoka.hotelini.home.data.network.Restaurantdto

data class RestaurantResponse(
    val data: Data,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)