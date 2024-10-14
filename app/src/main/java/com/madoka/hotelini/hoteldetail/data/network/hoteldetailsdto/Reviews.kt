package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class Reviews(
    val content: List<com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.ContentXXXXX>,
    val count: Int,
    val ratingCounts: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.RatingCounts,
    val ratingValue: Double
)