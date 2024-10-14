package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class Location(
    val address: String,
    val gettingThere: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.GettingThere,
    val neighborhood: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Neighborhood,
    val title: String,
    val walkability: Any
)