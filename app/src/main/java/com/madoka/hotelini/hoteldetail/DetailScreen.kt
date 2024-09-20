package com.madoka.hotelini.hoteldetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.hoteldetail.components.DetailsActions
import com.madoka.hotelini.hoteldetail.components.HotelImageBanner
import com.madoka.hotelini.hoteldetail.components.HotelImageCarousel
import com.madoka.hotelini.hoteldetail.components.HotelInfoSection


@Composable
fun HotelDetailsScreen() {
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

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.BottomCenter)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                            )
                    ) {

                        HotelInfoSection(modifier = Modifier)
                    }
//                    H'
                  //                    >;sa'

                }
            }

            //  }
        }
    }
}


@Composable
fun HotelInfo(modifier: Modifier = Modifier) {

    Column(
        modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ),


        ) {
        HotelInfoSection(modifier = Modifier)

        //AmenitiesSection()

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
