package com.madoka.hotelini.favourites.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoritesDao {
    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites_table ORDER BY hotelId DESC")
    fun getAllFavourites(): Flow<List<Favorite>>


    @Query("SELECT * FROM favorites_table WHERE  hotelId  == :hotelId")
    fun getAFavorites(hotelId: String): Flow<Favorite?>

    @Query("SELECT favorite FROM favorites_table WHERE  hotelId = :hotelId")
    fun isFavorite( hotelId: String): Flow<Boolean>

    @Delete
    suspend fun deleteAFavorite(favorite: Favorite)

    @Query("DELETE FROM favorites_table")
    suspend fun deleteAllFavorites()
}