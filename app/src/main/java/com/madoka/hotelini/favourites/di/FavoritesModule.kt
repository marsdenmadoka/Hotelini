package com.madoka.hotelini.favourites.di

import com.madoka.hotelini.favourites.data.respository.FavoritesRepositoryImpl
import com.madoka.hotelini.favourites.domain.repository.FavouriteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn


@Module
@InstallIn
abstract class FavoritesModule {
    @Binds
    abstract fun bindFavoritesRepository(
        favoritesRepositoryImpl: FavoritesRepositoryImpl
    ): FavouriteRepository
}