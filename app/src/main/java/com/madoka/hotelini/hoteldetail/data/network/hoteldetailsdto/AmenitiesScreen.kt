package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

import com.google.gson.annotations.SerializedName

data class AmenitiesScreen(
    @SerializedName("content")
    val content: List<String>,
    @SerializedName("title")
    val title: String
)