package com.madoka.hotelini.hoteldetail.hoteldetailsdto

data class RatingCounts(
    val average: Average,
    val excellent: Excellent,
    val poor: Poor,
    val terrible: Terrible,
    val veryGood: VeryGood
)