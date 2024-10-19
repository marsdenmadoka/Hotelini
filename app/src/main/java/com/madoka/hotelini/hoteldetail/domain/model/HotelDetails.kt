package com.madoka.hotelini.hoteldetail.domain.model

import com.google.gson.annotations.SerializedName
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
    @SerializedName("about")
    val about: About,
    @SerializedName("amenitiesScreen")
    val amenitiesScreen: List<AmenitiesScreen>,
    @SerializedName("attractionsNearby")
    val attractionsNearby: AttractionsNearby,
    @SerializedName("geoPoint")
    val geoPoint: GeoPoint,
    @SerializedName("location")
    val location: Location,
    @SerializedName("numberReviews")
    val numberReviews: Int,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("price")
    val price: Price,
    @SerializedName("qA")
    val qA: QA,
    @SerializedName("rankingDetails")
    val rankingDetails: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("restaurantsNearby")
    val restaurantsNearby: RestaurantsNearby,
    @SerializedName("reviews")
    val reviews: Reviews,
    @SerializedName("title")
    val title: String
)
