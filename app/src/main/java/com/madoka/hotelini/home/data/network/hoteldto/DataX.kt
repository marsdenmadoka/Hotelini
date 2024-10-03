package com.madoka.hotelini.home.data.network.hoteldto

data class DataX(
    val accentedLabel: Boolean,
    val badge: Badge,
    val bubbleRating: BubbleRating,
    val cardPhotos: List<CardPhoto>,
    val id: String,
    val isSponsored: Boolean,
    val priceDetails: Any,
    val priceForDisplay: Any,
    val priceSummary: Any,
    val primaryInfo: String,
    val provider: String,
    val secondaryInfo: String,
    val strikethroughPrice: Any,
    val title: String
)