package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class About(
    val content: List<com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Content>,
    val tags: List<String>,
    val title: String
)