package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class Location(
    val address: String,
    val gettingThere: GettingThere,
    val neighborhood: Neighborhood,
    val title: String,
    val walkability: Any
)