package com.madoka.hotelini.hoteldetail.data.repository

import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.common.util.Resource
import com.madoka.hotelini.hoteldetail.domain.model.HotelDetails
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