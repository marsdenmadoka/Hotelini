package com.madoka.hotelini.common.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
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
data class HotelInfo(  //this is what we pass to the Details Screen
    val id: String,
    val bubbleRating: @RawValue BubbleRating,
    val priceDetails: @RawValue Any?,
    val priceForDisplay: @RawValue Any?,
    val priceSummary: @RawValue Any?,
    val provider: String,
    val secondaryInfo: String,
    val title: String
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
    title = title  ?: "No title"
)
