package com.madoka.hotelini.home.data.network.dto

import com.madoka.hotelini.home.domain.model.Restaurant

data class Data(
    val currentPage: Int,
    val data: List<Restaurant>,
    val totalPages: Int,
    val totalRecords: Int
)


