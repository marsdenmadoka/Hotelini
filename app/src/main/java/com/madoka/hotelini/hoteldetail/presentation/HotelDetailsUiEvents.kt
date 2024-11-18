package com.madoka.hotelini.hoteldetail.presentation

import com.madoka.hotelini.favourites.data.local.Favorite


sealed interface HotelDetailsUiEvents {
    data object NavigateBack :  HotelDetailsUiEvents
//    data class NavigateToPhotosScreen(val credits: Ph) :
//        HotelDetailsUiEvents

    data class AddToFavorites(val favorite: Favorite) :
        HotelDetailsUiEvents

    data class RemoveFromFavorites(val favorite: Favorite) :
        HotelDetailsUiEvents

}