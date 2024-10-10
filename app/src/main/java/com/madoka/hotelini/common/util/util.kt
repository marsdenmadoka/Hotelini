package com.madoka.hotelini.common.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.*


val currentDate: String = SimpleDateFormat("yyyy-MM-dd",
    Locale.getDefault()).format(Date())



fun calculateDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val earthRadius = 6371.0 // Kilometers
    val dLat = Math.toRadians(lat2 - lat1)
    val dLon = Math.toRadians(lon2 - lon1)
    val a = sin(dLat / 2) * sin(dLat / 2) +
            cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2) * sin(dLon / 2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return earthRadius * c
}
