package com.madoka.hotelini.hoteldetail.hoteldetailsdto

data class Data(
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