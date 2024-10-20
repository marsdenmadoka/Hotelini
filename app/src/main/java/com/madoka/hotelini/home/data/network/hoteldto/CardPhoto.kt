package com.madoka.hotelini.home.data.network.hoteldto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class CardPhoto(
    val __typename: String,
    val sizes: @RawValue Sizes
) : Parcelable