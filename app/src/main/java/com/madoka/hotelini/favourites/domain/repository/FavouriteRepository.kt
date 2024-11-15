package com.madoka.hotelini.favourites.domain.repository

import com.madoka.hotelini.favourites.data.local.Favorite
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {
    suspend fun insertFavorite(favorite: Favorite)

    fun getFavorites(): Flow<List<Favorite>>
    fun getSingleFavorites(): Flow<List<Favorite>>
    suspend fun deleteOneFavorite(favorite: Favorite)
    suspend fun deleteAllFavorites()
}