package com.madoka.hotelini.home.domain.model

import com.google.gson.annotations.SerializedName
import com.madoka.hotelini.home.data.network.hoteldto.Badge
import com.madoka.hotelini.home.data.network.hoteldto.BubbleRating
import com.madoka.hotelini.home.data.network.hoteldto.CardPhoto

data class Hotel(
    @SerializedName("accentedLabel")
    val accentedLabel: Boolean,
    @SerializedName("Badge")
    val badge: Badge,
    @SerializedName("bubbleRating")
    val bubbleRating: BubbleRating,
    @SerializedName("cardPhotos")
    val cardPhotos: List<CardPhoto>,
    @SerializedName("id")
    val id: String,
    @SerializedName("isSponsored")
    val isSponsored: Boolean,
    @SerializedName("priceDetails")
    val priceDetails: Any,
    @SerializedName("priceForDisplay")
    val priceForDisplay: Any,
    @SerializedName("priceSummary")
    val priceSummary: Any,
    @SerializedName("primaryInfo")
    val primaryInfo: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("secondaryInfo")
    val secondaryInfo: String,
    @SerializedName("strikethroughPrice")
    val strikethroughPrice: Any,
    @SerializedName("title")
    val title: String
)



