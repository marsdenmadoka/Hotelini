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
    suspend fun getHotelDetails(hotelId: String): Resource<HotelDetailsResponses> {

        val response = try {
            api.getHotelDetails(hotelId)
        } catch (error: Exception) {
            return Resource.Error("error for details $error")
        }
        Timber.d("Hotel details: $response")
        return Resource.Success(response)
    }


}

//https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotelsByLocation?latitude=-3.4330033&longitude=38.356907&checkIn=2024-10-19&checkOut=2024-10-19&pageNumber=1
//


//.url("https://tripadvisor16.p.rapidapi.com/api/v1/hotels/getHotelDetails?id=112&checkIn=2024-10-17&checkOut=2024-10-16&currency=USD")
//https://tripadvisor16.p.rapidapi.com/api/v1/hotels/getHotelDetails/754603?checkIn=2024-10-19&checkOut=2024-10-19