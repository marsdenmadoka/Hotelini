package com.madoka.hotelini.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.common.util.Constants
import com.madoka.hotelini.home.data.network.Restaurantdto.RestaurantDetail
import com.madoka.hotelini.home.data.network.hoteldto.HotelDetails
import com.madoka.hotelini.home.data.paging.HotelSource
import com.madoka.hotelini.home.data.paging.RestaurantsSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotelRepository @Inject constructor(private val api: HoteliniApi) {

    fun getNearestHotels(
        latitude: Double, longitude: Double
    ): Flow<PagingData<HotelDetails>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = Constants.PAGING_SIZE),
            pagingSourceFactory = {
                HotelSource(api,
                    latitude,
                    longitude)

            }
        ).flow
    }

}