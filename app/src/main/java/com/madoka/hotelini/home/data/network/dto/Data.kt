package com.madoka.hotelini.home.data.network.dto

import com.google.gson.annotations.SerializedName

data class Data(
    val currentPage: Int,
    val `data`: List<DataX>,
    val totalPages: Int,
    val totalRecords: Int
)



data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
