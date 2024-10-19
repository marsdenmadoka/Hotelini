import com.google.gson.annotations.SerializedName
import com.madoka.hotelini.home.data.network.hoteldto.Badge
import com.madoka.hotelini.home.data.network.hoteldto.BubbleRating
import com.madoka.hotelini.home.data.network.hoteldto.CardPhoto
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.About
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AmenitiesScreen
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.AttractionsNearby
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.GeoPoint
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.HotelDetailsResponseDetails
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Location
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Photo
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Price
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.QA
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.RestaurantsNearby
import com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Reviews

//package com.madoka.hotelini.common.domain.model
//
//internal fun CreditsResponse.toDomain() = Credits(
//    id = id,
//    cast = cast.map { it.toDomain() }
//)
//
//internal fun CastResponse.toDomain() = Cast(
//    adult = adult,
//    castId = castId,
//    character = character,
//    creditId = creditId,
//    gender = gender,
//    id = id,
//    knownForDepartment = knownForDepartment,
//    name = name,
//    order = order,
//    originalName = originalName,
//    popularity = popularity,
//    profilePath = profilePath,
//)
//


internal fun HotelDetailsResponseDetails.toHotel():HotelDetails{

    return HotelDetails(
        about = about,
        amenitiesScreen = amenitiesScreen,
    )
}

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
data class Hotel(
    @SerializedName("accentedLabel")
    val accentedLabel: Boolean,
    @SerializedName("Badge")
    val badge: Badge,
    @SerializedName("bubbleRating")
    val bubbleRating: BubbleRating,
    @SerializedName("cardPhotos")
    val cardPhotos: List<CardPhoto>,
    @SerializedName("id")
    val id: String,
    @SerializedName("isSponsored")
    val isSponsored: Boolean,
    @SerializedName("priceDetails")
    val priceDetails: Any,
    @SerializedName("priceForDisplay")
    val priceForDisplay: Any,
    @SerializedName("priceSummary")
    val priceSummary: Any,
    @SerializedName("primaryInfo")
    val primaryInfo: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("secondaryInfo")
    val secondaryInfo: String,
    @SerializedName("strikethroughPrice")
    val strikethroughPrice: Any,
    @SerializedName("title")
    val title: String
)
