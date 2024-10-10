package com.madoka.hotelini.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.common.util.Constants
import com.madoka.hotelini.home.data.paging.HotelSource
import com.madoka.hotelini.home.domain.model.Hotel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotelRepository @Inject constructor(private val api: HoteliniApi) {

    fun getNearestHotels(
        latitude: Double, longitude: Double
    ): Flow<PagingData<Hotel>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = Constants.PAGING_SIZE),
            pagingSourceFactory = {
                HotelSource(api,latitude,longitude)

            }
        ).flow
    }

}