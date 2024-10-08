package com.madoka.hotelini.common.data.network

import com.madoka.hotelini.BuildConfig.API_KEY
import com.madoka.hotelini.common.util.Constants.API_HOST
import com.madoka.hotelini.common.util.Constants.STARTING_PAGE_INDEX
import com.madoka.hotelini.common.util.currentDate
import com.madoka.hotelini.home.data.network.Restaurantdto.RestaurantResponse
import com.madoka.hotelini.home.data.network.hoteldto.HotelResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface HoteliniApi {

    @GET("restaurant/searchRestaurants?locationId=304554")
    suspend fun getHotelsInNairobi(

        // @Query("page") page: Int = STARTING_PAGE_INDEX,
        //@Query("api_key") apiKey: String = API_KEY
//    @Query("latitude") latitude: Double,
//    @Query("longitude") longitude: Double
        @Header("x-rapidapi-key") apiKey: String = API_KEY,
        @Header("x-rapidapi-host") apiHost: String = API_HOST,
//    @Query("locationId") locationId: String,
        @Query("page") page: Int = STARTING_PAGE_INDEX
    ): RestaurantResponse


    @GET("hotels/searchHotelsByLocation")
    suspend fun getNearestHotels(
        @Header("x-rapidapi-key") apiKey: String = API_KEY,
        @Header("x-rapidapi-host") apiHost: String = API_HOST,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("checkIn") checkIn: String = currentDate,
        @Query("checkOut") checkOut: String =  currentDate,
        @Query("pageNumber") pageNumber: Int = STARTING_PAGE_INDEX,


    ): HotelResponse

    @GET()//get the hotel details
    suspend fun getHotelDetails(

    ): HotelResponse



}