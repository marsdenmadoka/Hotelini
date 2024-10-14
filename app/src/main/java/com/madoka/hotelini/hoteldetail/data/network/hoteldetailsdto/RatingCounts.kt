package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class RatingCounts(
    val average: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Average,
    val excellent: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Excellent,
    val poor: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Poor,
    val terrible: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Terrible,
    val veryGood: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.VeryGood
)