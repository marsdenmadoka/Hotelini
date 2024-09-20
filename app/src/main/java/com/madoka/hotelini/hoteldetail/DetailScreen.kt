package com.madoka.hotelini.hoteldetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.hoteldetail.components.DetailsActions
import com.madoka.hotelini.hoteldetail.components.HotelImageBanner
import com.madoka.hotelini.hoteldetail.components.HotelInfoSection




@Composable
fun HotelDetailsScreen(){
    HotelDetailScreenContent()
}


@Composable
fun HotelDetailScreenContent() {
    Scaffold(
        topBar = {
            DetailsActions(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                //.background(color = Color.Transparent.copy(alpha = 0.5f)),
            )
        }

    ) { InnerPadding ->

        //Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                //verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {


                item {
                    Box(modifier = Modifier.fillMaxSize()) {
                    HotelImageBanner(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp),
                       // filmImage ="https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                    )

                    HotelImageCarousel(
                        modifier = Modifier
                            .height(250.dp)
                            .align(Alignment.BottomCenter)

                    )
                }

//                item {
//
//                }
//
//            item {
//                Box(
//                    Modifier
//                        .fillMaxSize()
//                        .align(Alignment.BottomCenter)
//                        .background(
//                            color = Color.White,
//                            shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
//                        ),
//
//                    ) {
//                            HotelInfoSection()
//                            //AmenitiesSection()
//
//                   // }
//                }
//
//
//            }

          //  }
        }
            }
    }
}


@Composable
fun HotelImageCarousel(modifier: Modifier = Modifier) {
    Column(
        modifier
            .background(
                color = Color(android.graphics.Color.parseColor("#a045ff")),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ),
        verticalArrangement = Arrangement.Bottom,
    ) {
        val imageItems: Int = 7
        val visibleItemCount: Int = 3

        val displayedItems = if (imageItems > visibleItemCount) {
            visibleItemCount - 1 // Show all but the last one
        } else {
            imageItems // If items fit, display them all
        }

        val remainingItemCount = imageItems - displayedItems // Remaining items count


        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(android.graphics.Color.parseColor("#a045ff")),
                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top,

            ) {
            items(displayedItems) {// Simulating three hotel images
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp)
                        .height(70.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(
                        4.dp
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_load_error), // Replace with your image resources
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            if (remainingItemCount > 0) {
                item {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(70.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF7B4EFF)
                        )
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "+$remainingItemCount", // Show the number of remaining items
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
//    Box(
//        Modifier
//            .fillMaxSize()
//            .background(
//                color = MaterialTheme.colorScheme.onSecondaryContainer,
//                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
//            ),
//
//        ) {
//        Column(
//
//            Modifier
//                .padding(top = 20.dp)
//        ) {
////add view loaction icon
//            // 2. Hotel info
//            HotelInfoSection()
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // 3. Room info
//            RoomInfoSection()
//
//            Divider(color = Color.LightGray, thickness = 1.dp)
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // 4. Amenities Section
//            AmenitiesSection()
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // 5. Description Section
//            HotelDescriptionSection()
//        }
//    }
//}

// Overlay for "+5" button on top of the carousel

//}

@Composable
fun HotelDescriptionSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Description", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(
            text = "This beautiful hotel offers a luxurious stay with modern amenities such as free WiFi, pool, and parking.",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHotelDetailScreen2() {
    HoteliniTheme {
        HotelDetailsScreen()
    }
}
