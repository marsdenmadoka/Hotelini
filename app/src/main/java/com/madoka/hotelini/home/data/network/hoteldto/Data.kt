package com.madoka.hotelini.home.data.network.hoteldto

import com.madoka.hotelini.home.domain.model.Hotel

data class Data(
    val currentPage: Int,
    val data: List<Hotel>,
    val sortDisclaimer: String
)