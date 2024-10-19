 package com.madoka.hotelini.home.presentation

import androidx.compose.foundation.background
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.madoka.hotelini.common.domain.model.HotelInfo
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.hoteldetail.presentation.components.AmenitiesSection
import com.madoka.hotelini.hoteldetail.presentation.components.DetailsActions
import com.madoka.hotelini.hoteldetail.presentation.components.HotelDescriptionSection
import com.madoka.hotelini.hoteldetail.presentation.components.HotelImageBanner
import com.madoka.hotelini.hoteldetail.presentation.components.HotelInfoSection
import com.madoka.hotelini.hoteldetail.presentation.components.RoomInfoSection
import com.madoka.hotelini.hoteldetail.presentation.components.SmallImagesRow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/*
@Composable
fun OverlappingCards() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Create references for the cards
        val (card1, card2, card3) = createRefs()

        // Card 1
        Box(
            modifier = Modifier
                .constrainAs(card1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .height(150.dp)
                .background(Color.Red, RoundedCornerShape(16.dp))
        )

        // Card 2 (overlapping card1)
        Box(
            modifier = Modifier
                .constrainAs(card2) {
                    top.linkTo(card1.bottom, margin = (-50).dp) // Negative margin to overlap
                    start.linkTo(card1.start)
                    end.linkTo(card1.end)
                    width = Dimension.fillToConstraints
                }
                .height(150.dp)
                .background(Color.Green, RoundedCornerShape(16.dp))
        )

        // Card 3 (overlapping card2)
        Box(
            modifier = Modifier
                .constrainAs(card3) {
                    top.linkTo(card2.bottom, margin = (-50).dp) // Negative margin to overlap
                    start.linkTo(card2.start)
                    end.linkTo(card2.end)
                    width = Dimension.fillToConstraints
                }
                .height(150.dp)
                .background(Color.Blue, RoundedCornerShape(16.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOverlappingCards() {
    MaterialTheme {
        OverlappingCards()
    }
} */


 @Preview
 @Composable
 fun HotelDetailsScreen() {
     Column(
         modifier = Modifier
             .fillMaxSize()
             .verticalScroll(rememberScrollState())
             .background(Color.White)
     ) {
         // Image carousel
         ImageCarousel(
             imageUrls = listOf(
                 "image_url_1", "image_url_2", "image_url_3", "image_url_4"
             ),
             remainingImages = 5 // For the +5 card
         )

         // Hotel info
         HotelInfoSection(
             hotelName = "Wyndham Garden Washington",
             location = "Annapolis Road, Washington",
             rating = 4.98,
             reviewCount = 237,
             pricePerNight = 150.00,
             guestCount = 2,
             bathCount = 1,
             bedroomCount = 1
         )

         // Amenities
         AmenitiesSection()

         // Description and more info (if applicable)
     }
 }

 @Composable
 fun ImageCarousel(imageUrls: List<String>, remainingImages: Int) {
     LazyRow(
         modifier = Modifier
             .fillMaxWidth()
             .height(200.dp)
     ) {
         items(imageUrls.size) { index ->
             Image(
                 painter = rememberAsyncImagePainter(imageUrls[index]),
                 contentDescription = null,
                 modifier = Modifier
                     .padding(8.dp)
                     .size(150.dp)
                     .clip(RoundedCornerShape(10.dp)),
                 contentScale = ContentScale.Crop
             )
         }

         // Show the "+5" card if more images are available
         item {
             Box(
                 contentAlignment = Alignment.Center,
                 modifier = Modifier
                     .padding(8.dp)
                     .size(150.dp)
                     .clip(RoundedCornerShape(10.dp))
                     .background(Color.LightGray)
             ) {
                 Text(
                     text = "+$remainingImages",
                     style = MaterialTheme.typography.headlineSmall,
                     color = Color.White
                 )
             }
         }
     }
 }

 @Composable
 fun HotelInfoSection(
     hotelName: String,
     location: String,
     rating: Double,
     reviewCount: Int,
     pricePerNight: Double,
     guestCount: Int,
     bathCount: Int,
     bedroomCount: Int
 ) {
     Column(
         modifier = Modifier
             .fillMaxWidth()
             .padding(16.dp)
     ) {
         Text(
             text = hotelName,
             style = MaterialTheme.typography.headlineSmall,
             color = Color.Black
         )
         Spacer(modifier = Modifier.height(4.dp))
         Row(
             verticalAlignment = Alignment.CenterVertically
         ) {
             Icon(
                 imageVector = Icons.Default.LocationOn,
                 contentDescription = null,
                 tint = Color.Gray,
                 modifier = Modifier.size(16.dp)
             )
             Text(text = location, style = MaterialTheme.typography.bodyMedium)
         }
         Spacer(modifier = Modifier.height(8.dp))

         // Rating and review count
         Row(
             verticalAlignment = Alignment.CenterVertically
         ) {
             Text(text = "$rating", style = MaterialTheme.typography.bodySmall)
             Spacer(modifier = Modifier.width(4.dp))
             Text(text = "(${reviewCount} reviews)", style = MaterialTheme.typography.bodyMedium)
         }

         Spacer(modifier = Modifier.height(16.dp))

         // Price
         Text(
             text = "$${pricePerNight} Per Night",
             style = MaterialTheme.typography.displaySmall,
             color = Color.Black
         )
         Spacer(modifier = Modifier.height(16.dp))

         // Room details
         Row(
             horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
             RoomDetail(icon = Icons.Default.Person, text = "$guestCount guest")
             RoomDetail(icon = Icons.Default.Face, text = "$bathCount Bath")
             RoomDetail(icon = Icons.Default.Warning,text = "$bedroomCount Bedroom")
         }
     }
 }

 @Composable
 fun RoomDetail(icon: ImageVector, text: String) {
     Row(
         verticalAlignment = Alignment.CenterVertically
     ) {
         Icon(
             imageVector = icon,
             contentDescription = null,
             tint = Color.Gray,
             modifier = Modifier.size(16.dp)
         )
         Spacer(modifier = Modifier.width(4.dp))
         Text(text = text, style = MaterialTheme.typography.bodyMedium)
     }
 }

 @Composable
 fun AmenitiesSection() {
     Column(modifier = Modifier.padding(16.dp)) {
         Text(text = "What this place offers", style = MaterialTheme.typography.headlineMedium)
         Spacer(modifier = Modifier.height(8.dp))
         Row(
             horizontalArrangement = Arrangement.spacedBy(16.dp),
             modifier = Modifier.fillMaxWidth()
         ) {
             Amenity(icon = Icons.Default.AccountCircle, text = "Wifi")
             Amenity(icon = Icons.Default.AccountCircle, text = "Pool")
             Amenity(icon = Icons.Default.AccountCircle, text = "Free parking")
         }
     }
 }

 @Composable
 fun Amenity(icon: ImageVector, text: String) {
     Column(horizontalAlignment = Alignment.CenterHorizontally) {
         Icon(
             imageVector = icon,
             contentDescription = null,
             tint = Color.Gray,
             modifier = Modifier.size(24.dp)
         )
         Text(text = text, style = MaterialTheme.typography.bodyMedium)
     }
 }
