package com.madoka.hotelini.home.data.network.dto

data class Data(
    val currentPage: Int,
    val data: List<RestaurantDetail>,
    val totalPages: Int,
    val totalRecords: Int
)


