package com.madoka.hotelini.favourites.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


//@Database(entities = [Favorite::class], version = 5, exportSchema = true)
@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract val dao: FavoritesDao
}
