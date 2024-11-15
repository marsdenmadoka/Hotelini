package com.madoka.hotelini.favourites.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.madoka.hotelini.common.util.Constants.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class Favorite(
    val favorite: Boolean,
    @PrimaryKey val hotelId: Int,
    val image: String,
    val rating: Float,
    val title: String,
    val reviews: Int
)