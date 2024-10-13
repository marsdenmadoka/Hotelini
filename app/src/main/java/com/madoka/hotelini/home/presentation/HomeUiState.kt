package com.madoka.hotelini.home.presentation

import androidx.paging.PagingData
import com.madoka.hotelini.common.util.Resource
import com.madoka.hotelini.home.data.network.Restaurantdto.RestaurantDetail
import com.madoka.hotelini.home.data.network.hoteldto.HotelDetails
import com.madoka.hotelini.home.domain.model.Hotel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HomeUiState(

    val nearestHotels: Flow<PagingData<Hotel>> = emptyFlow(),
    val hotelDistances: Map<String, String> = emptyMap(), // Store distances keyed by hotel title

      val carousel:Flow<Resource<List<Hotel>>> = emptyFlow()
) //using state to  manage VM