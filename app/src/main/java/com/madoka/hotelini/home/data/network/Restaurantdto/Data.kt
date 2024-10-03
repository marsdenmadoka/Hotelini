package com.madoka.hotelini.home.data.network.Restaurantdto

data class Data(
    val currentPage: Int,
    val data: List<RestaurantDetail>,
    val totalPages: Int,
    val totalRecords: Int
)


