package com.madoka.hotelini.favourites.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.madoka.hotelini.common.util.Constants.TABLE_NAME
import com.madoka.hotelini.home.data.network.hoteldto.BubbleRating
import com.madoka.hotelini.home.data.network.hoteldto.CardPhoto
import kotlinx.parcelize.RawValue


@Entity(tableName = TABLE_NAME)
data class Favorite(
    val favorite: Boolean,
    @PrimaryKey val hotelId: Int,
    val bubbleRating: @RawValue BubbleRating,
    val priceDetails: @RawValue Any?,
    val priceForDisplay: @RawValue Any?,
    val priceSummary: @RawValue Any?,
    val provider: String,
    val secondaryInfo: String,
    val title: String,
    val cardPhotos: @RawValue List<CardPhoto>
)


