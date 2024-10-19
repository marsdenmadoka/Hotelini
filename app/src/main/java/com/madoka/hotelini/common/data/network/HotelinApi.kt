package com.madoka.hotelini.common.data.network

import com.madoka.hotelini.BuildConfig.API_KEY
import com.madoka.hotelini.common.util.Constants.API_HOST
import com.madoka.hotelini.common.util.Constants.STARTING_PAGE_INDEX
import com.madoka.hotelini.common.util.currentDate
import com.madoka.hotelini.home.data.network.Restaurantdto.RestaurantResponse
import com.madoka.hotelini.home.data.network.hoteldto.HotelResponse
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.HotelDetailsResponses
import com.madoka.hotelini.hoteldetail.domain.model.HotelDetails
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface HoteliniApi {


    @GET("hotels/searchHotelsByLocation")
    suspend fun getNearestHotels(
        @Header("x-rapidapi-key") apiKey: String = API_KEY,
        @Header("x-rapidapi-host") apiHost: String = API_HOST,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("checkIn") checkIn: String = currentDate,
        @Query("checkOut") checkOut: String = currentDate,
        @Query("pageNumber") pageNumber: Int = STARTING_PAGE_INDEX,
    ): HotelResponse

    @GET("hotels/getHotelDetails/{hotelId}")
    fun getHotelDetails(
        @Path("id") hotelId: String,
        @Query("checkIn") checkInDate: String = currentDate,
        @Query("checkOut") checkOutDate: String = currentDate,
        @Header("x-rapidapi-key") apiKey: String = API_KEY,
        @Header("x-rapidapi-host") apiHost: String = API_HOST
    ): HotelDetails

}