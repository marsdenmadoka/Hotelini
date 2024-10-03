package com.madoka.hotelini.home.domain.model

import com.google.gson.annotations.SerializedName
import com.madoka.hotelini.home.data.network.Restaurantdto.AwardInfo
import com.madoka.hotelini.home.data.network.Restaurantdto.Offers
import com.madoka.hotelini.home.data.network.Restaurantdto.ReviewSnippets
import com.madoka.hotelini.home.data.network.Restaurantdto.Thumbnail

data class Restaurant1 (
    @SerializedName("averageRating")
    val averageRating: Double,
    val awardInfo: AwardInfo,
    val currentOpenStatusCategory: String,
    val currentOpenStatusText: String,
    @SerializedName("distanceTo")
    val distanceTo: Any,
    val establishmentTypeAndCuisineTags: List<String>,
    val hasMenu: Boolean,
    val heroImgRawHeight: Int,
    val heroImgRawWidth: Int,
    @SerializedName("heroImgUrl")
    val heroImgUrl: String,
    val isDifferentGeo: Boolean,
    val isLocalChefItem: Boolean,
    val isPremium: Boolean,
    val isStoryboardPublished: Boolean,
    val locationId: Int,
    val menuUrl: String,
    @SerializedName("name")
    val name: String,
    val offers: Offers,
    val parentGeoName: String,
    val priceTag: String,
    val restaurantsId: String,
    val reviewSnippets: ReviewSnippets,
    val squareImgRawLength: Int,
    @SerializedName("squareImgUrl")
    val squareImgUrl: String,
    val thumbnail: Thumbnail,
    @SerializedName("userReviewCount")
    val userReviewCount: Int

)