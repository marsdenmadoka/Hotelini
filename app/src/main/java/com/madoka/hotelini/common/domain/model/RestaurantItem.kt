package com.madoka.hotelini.common.domain.model

data class RestaurantItem(
    val averageRating: Double,
    //val distanceTo: Any,
    val heroImgUrl: String,
    val name: String,
   // val squareImgUrl: String,
    val userReviewCount: Int
)
