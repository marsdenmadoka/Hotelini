package com.madoka.hotelini.home.data.network.dto

data class RestrauntResponse(
    val `data`: Data,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)