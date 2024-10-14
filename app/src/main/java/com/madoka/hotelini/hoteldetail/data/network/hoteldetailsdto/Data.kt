package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class Data( //map to dto
    val about: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.About,
    val amenitiesScreen: List<com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AmenitiesScreen>,
    val attractionsNearby: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AttractionsNearby,
    val geoPoint: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.GeoPoint,
    val location: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Location,
    val numberReviews: Int,
    val photos: List<com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Photo>,
    val price: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Price,
    val qA: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.QA,
    val rankingDetails: String,
    val rating: Double,
    val restaurantsNearby: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.RestaurantsNearby,
    val reviews: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Reviews,
    val title: String
)