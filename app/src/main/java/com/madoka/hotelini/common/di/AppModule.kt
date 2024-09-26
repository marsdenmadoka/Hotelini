package com.madoka.hotelini.common.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.madoka.hotelini.common.data.repository.PreferenceRepositoryImpl
import com.madoka.hotelini.common.domain.repository.PreferenceRepository
import com.madoka.hotelini.common.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatastorePreferences(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(Constants.HOTELINI_PREFERENCES)
            }
        )
    @Provides
    @Singleton
    fun providePreferenceRepository(dataStore: DataStore<Preferences>): PreferenceRepository =
        PreferenceRepositoryImpl(dataStore)

}