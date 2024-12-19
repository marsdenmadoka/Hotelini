package com.madoka.hotelini.favourites.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.madoka.hotelini.home.data.network.hoteldto.BubbleRating
import com.madoka.hotelini.home.data.network.hoteldto.CardPhoto

class FavoriteTypeConverters {
    private val gson = Gson()
    @TypeConverter
    fun fromBubbleRating(bubbleRating: BubbleRating): String {
        return gson.toJson(bubbleRating)
    }

    @TypeConverter
    fun toBubbleRating(json: String): BubbleRating {
        return gson.fromJson(json, BubbleRating::class.java)
    }

    @TypeConverter
    fun fromCardPhotoList(cardPhotos: List<CardPhoto>): String {
        return gson.toJson(cardPhotos)
    }

    @TypeConverter
    fun toCardPhotoList(json: String): List<CardPhoto> {
        val type = object : TypeToken<List<CardPhoto>>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromAny(anyObject: Any?): String? {
        return gson.toJson(anyObject)
    }

    @TypeConverter
    fun toAny(json: String?): Any? {
        return json?.let { gson.fromJson(it, Any::class.java) }
    }
}
