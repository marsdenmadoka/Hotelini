package com.madoka.hotelini.hoteldetail.hoteldetailsdto

data class About(
    val content: List<Content>,
    val tags: List<String>,
    val title: String
)