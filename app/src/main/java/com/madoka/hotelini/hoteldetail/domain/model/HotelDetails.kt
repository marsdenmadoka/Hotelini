package com.madoka.hotelini.hoteldetail.domain.model

import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.About
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AmenitiesScreen
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AttractionsNearby
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.GeoPoint
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Location
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Photo
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Price
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.QA
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.RestaurantsNearby
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Reviews

data class HotelDetails(
    val about: About,
    val amenitiesScreen: List<AmenitiesScreen>,
    val attractionsNearby: AttractionsNearby,
    val geoPoint: GeoPoint,
    val location: Location,
    val numberReviews: Int,
    val photos: List<Photo>,
    val price: Price,
    val qA: QA,
    val rankingDetails: String,
    val rating: Double,
    val restaurantsNearby: RestaurantsNearby,
    val reviews: Reviews,
    val title: String
)