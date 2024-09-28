package com.madoka.hotelini.common.util

import androidx.datastore.preferences.core.intPreferencesKey

object Constants {

    const val BASE_URL = "https://tripadvisor16.p.rapidapi.com/api/v1/"
    const val HOTELINI_PREFERENCES = "HOTELINI_PREFERENCES"
    val THEME_OPTIONS = intPreferencesKey(name = "theme_option")
   const val STARTING_PAGE_INDEX = 0

}