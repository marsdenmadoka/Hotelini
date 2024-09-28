package com.madoka.hotelini.home.data.repository

import androidx.paging.PagingData
import com.madoka.hotelini.common.data.network.HoteliniApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val api:HoteliniApi){

fun getResutrants(): Flow<PagingData>

}