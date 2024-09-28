package com.madoka.hotelini.home.data.network.dto

data class Slot1Offer(
    val buttonText: String,
    val canLockTimeslots: Boolean,
    val canProvideTimeslots: Boolean,
    val logoUrl: String,
    val offerURL: String,
    val provider: String,
    val providerDisplayName: String,
    val providerId: String,
    val timeSlots: List<Any>,
    val trackingEvent: String
)