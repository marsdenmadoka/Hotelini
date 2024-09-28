package com.madoka.hotelini.home.data.network.dto

import com.google.gson.annotations.SerializedName

data class Data(
    val currentPage: Int,
    val data: List<DataX>,
    val totalPages: Int,
    val totalRecords: Int
)


