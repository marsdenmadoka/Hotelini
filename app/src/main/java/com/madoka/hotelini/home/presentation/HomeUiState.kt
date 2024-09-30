package com.madoka.hotelini.home.presentation

import androidx.paging.PagingData
import com.madoka.hotelini.home.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HomeUiState(
    val restaurants: Flow<PagingData<Restaurant>> = emptyFlow()

)