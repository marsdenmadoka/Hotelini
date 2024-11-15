package com.madoka.hotelini.favourites.data.respository

import com.madoka.hotelini.favourites.data.local.Favorite
import com.madoka.hotelini.favourites.data.local.FavoritesDatabase
import com.madoka.hotelini.favourites.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FavoritesRepositoryImpl @Inject constructor(private val database: FavoritesDatabase) :
    FavouriteRepository {
    override suspend fun insertFavorite(favorite: Favorite) {
        database.dao.insertFavorite(favorite)
    }

    override fun getFavorites(): Flow<List<Favorite>> {
        return database.dao.getAllFavourites()
    }

    override fun getSingleFavorites(): Flow<List<Favorite>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteOneFavorite(favorite: Favorite) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllFavorites() {
        TODO("Not yet implemented")
    }

}