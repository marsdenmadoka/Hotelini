package com.madoka.hotelini.home.presentation


sealed interface HomeUiEvents {
    data object NavigateBack : HomeUiEvents
    data object OnPullToRefresh : HomeUiEvents

    data class NavigateToHotelDetails(
        val hotel: Film,
    ) : HomeUiEvents

//    data class OnFilmGenreSelected(
//        val genre: Genre,
//        val filmType: String,
//        val selectedFilmOption: String
//    ) : HomeUiEvents

    data class OnFilmOptionSelected(val item: String) :
        HomeUiEvents
}
