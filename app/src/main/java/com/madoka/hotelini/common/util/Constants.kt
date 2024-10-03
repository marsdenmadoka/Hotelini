package com.madoka.hotelini.common.util

import androidx.datastore.preferences.core.intPreferencesKey
import java.util.Date

object Constants {

    const val BASE_URL = "https://tripadvisor16.p.rapidapi.com/api/v1/"
    const val HOTELINI_PREFERENCES = "HOTELINI_PREFERENCES"
    const val API_HOST = "tripadvisor16.p.rapidapi.com"
    val THEME_OPTIONS = intPreferencesKey(name = "theme_option")
    const val STARTING_PAGE_INDEX = 0
    const val PAGING_SIZE = 20

}