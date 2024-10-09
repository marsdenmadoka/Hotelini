package com.madoka.hotelini.home.presentation

import com.madoka.hotelini.common.domain.model.HotelInfo


sealed interface HomeUiEvents {
    data object NavigateBack : HomeUiEvents
    data object OnPullToRefresh : HomeUiEvents

    data class NavigateToHotelDetails(
        val hotel: HotelInfo,
    ) : HomeUiEvents

}
