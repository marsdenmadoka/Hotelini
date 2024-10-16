package com.madoka.hotelini.home.data.network.hoteldto
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BubbleRating(
    val count: String,
    val rating: Double
) : Parcelable

