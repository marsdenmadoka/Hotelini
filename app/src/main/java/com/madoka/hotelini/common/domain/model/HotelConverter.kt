package com.madoka.hotelini.common.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.madoka.hotelini.favourites.data.local.Favorite
import com.madoka.hotelini.home.data.network.hoteldto.Badge
import kotlinx.parcelize.Parcelize
import com.madoka.hotelini.home.data.network.hoteldto.BubbleRating
import com.madoka.hotelini.home.data.network.hoteldto.CardPhoto
import com.madoka.hotelini.home.domain.model.Hotel
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.About
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AmenitiesScreen
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AttractionsNearby
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.GeoPoint
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Location
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Photo
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Price
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.QA
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.RestaurantsNearby
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Reviews
import kotlinx.parcelize.RawValue

@Parcelize
data class HotelInfo(
    val id: String,
    val bubbleRating: @RawValue BubbleRating,
    val priceDetails: @RawValue Any?,
    val priceForDisplay: @RawValue Any?,
    val priceSummary: @RawValue Any?,
    val provider: String,
    val secondaryInfo: String,
    val title: String,
    val cardPhotos: @RawValue List<CardPhoto>
) : Parcelable


fun Hotel.toHotelInfo(
) = HotelInfo(
    id = id,
    bubbleRating = bubbleRating,
    priceDetails = priceDetails ?: "Unknown",
    priceForDisplay = priceForDisplay ?: "N/A",
    priceSummary = priceSummary ?: "No Summary",
    provider = provider ?: "no provider",
    secondaryInfo = secondaryInfo  ?: "No ptovider",
    title = title  ?: "No title",
    cardPhotos=cardPhotos,
)


fun Favorite.toHotelInfo(
) = HotelInfo(
    id = hotelId.toString(),
    bubbleRating = bubbleRating,
    priceDetails = priceDetails ?: "Unknown",
    priceForDisplay = priceForDisplay ?: "N/A",
    priceSummary = priceSummary ?: "No Summary",
    provider = provider ?: "no provider",
    secondaryInfo = secondaryInfo  ?: "No ptovider",
    title = title  ?: "No title",
    cardPhotos=cardPhotos,
)






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