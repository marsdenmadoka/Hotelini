package com.madoka.hotelini.common.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.madoka.hotelini.home.data.network.hoteldto.Badge
import com.madoka.hotelini.home.data.network.hoteldto.BubbleRating
import com.madoka.hotelini.home.data.network.hoteldto.CardPhoto
import com.madoka.hotelini.home.domain.model.Hotel
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotelInfo(  //this is what we pass to the Details Screen
    val id: String,
//    val bubbleRating: BubbleRating,
//    val cardPhotos: List<CardPhoto>,
//    val priceDetails: Any,
//    val priceForDisplay: Any,
//    val priceSummary: Any,
    val provider: String,
    val secondaryInfo: String,
    val title: String
) : Parcelable

fun Hotel.toHotelInfo(

) = HotelInfo(
    id = id,
//    bubbleRating = bubbleRating,
//    cardPhotos = cardPhotos,
//    priceDetails = priceDetails,
//    priceForDisplay = priceForDisplay,
//    priceSummary = priceSummary,
     provider = provider,
    secondaryInfo = secondaryInfo,
    title = title
)

data class HotelDetails(
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