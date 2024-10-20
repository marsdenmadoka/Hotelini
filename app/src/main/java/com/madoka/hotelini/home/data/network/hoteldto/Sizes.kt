package com.madoka.hotelini.home.data.network.hoteldto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Sizes(
    val __typename: String,
    val maxHeight: Int,
    val maxWidth: Int,
    val urlTemplate: String
) : Parcelable