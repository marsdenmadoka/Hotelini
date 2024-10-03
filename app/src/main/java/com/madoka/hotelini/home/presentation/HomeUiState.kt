package com.madoka.hotelini.home.presentation

import androidx.paging.PagingData
import com.madoka.hotelini.home.data.network.dto.RestaurantDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HomeUiState(
    val restaurants: Flow<PagingData<RestaurantDetail>> = emptyFlow()

)