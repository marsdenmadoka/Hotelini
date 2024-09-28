package com.madoka.hotelini.home.data.network.dto

data class Offers(
    val hasDelivery: Boolean,
    val hasReservation: Boolean,
    val restaurantSpecialOffer: Any,
    val slot1Offer: Slot1Offer,
    val slot2Offer: Any
)