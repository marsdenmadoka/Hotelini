package com.madoka.hotelini.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.common.util.Constants.PAGING_SIZE
import com.madoka.hotelini.home.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val api:HoteliniApi){

fun getRestaurant(): Flow<PagingData<Restaurant>>{
    return Pager(
        config = PagingConfig(enablePlaceholders = false,pageSize = PAGING_SIZE),
        pagingSourceFactory = {

        }
    ).flow
}

}