package com.madoka.hotelini.common.domain.model

import com.google.gson.annotations.SerializedName
import com.madoka.hotelini.home.data.network.dto.AwardInfo
import com.madoka.hotelini.home.data.network.dto.Offers
import com.madoka.hotelini.home.data.network.dto.ReviewSnippets
import com.madoka.hotelini.home.data.network.dto.Thumbnail

data class RestaurantItem(
    val averageRating: Double,
    //val distanceTo: Any,
    val heroImgUrl: String,
    val name: String,
   // val squareImgUrl: String,
    val userReviewCount: Int
)
