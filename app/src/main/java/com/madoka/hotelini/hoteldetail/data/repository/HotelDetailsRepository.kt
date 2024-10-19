package com.madoka.hotelini.hoteldetail.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.common.util.Constants
import com.madoka.hotelini.common.util.Resource
import com.madoka.hotelini.home.data.paging.HotelSource
import com.madoka.hotelini.home.domain.model.Hotel
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.HotelDetailsResponses
import com.madoka.hotelini.hoteldetail.domain.model.HotelDetails
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class HotelDetailsRepository @Inject constructor(private val api: HoteliniApi) {
    suspend fun getHotelDetails(hotelId: String): Resource<HotelDetails> {
        val response = try {
            api.getHotelDetails(hotelId)
        } catch (e: Exception) {
            return Resource.Error("Unknown error occurred")
        }
       Timber.d("Hotel details: $response")
        return Resource.Success(response)
    }


}