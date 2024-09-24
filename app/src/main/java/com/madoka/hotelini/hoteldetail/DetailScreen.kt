package com.madoka.hotelini.hoteldetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.hoteldetail.components.AmenitiesSection
import com.madoka.hotelini.hoteldetail.components.DetailsActions
import com.madoka.hotelini.hoteldetail.components.HotelDescriptionSection
import com.madoka.hotelini.hoteldetail.components.HotelImageBanner
import com.madoka.hotelini.hoteldetail.components.HotelInfoSection
import com.madoka.hotelini.hoteldetail.components.RoomInfoSection
import com.madoka.hotelini.hoteldetail.components.SmallImagesRow


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
            )
        }

    ) { innerPadding ->

        LazyColumn {
            item {
                ConstraintLayout(modifier = Modifier.fillMaxSize()
                    .padding(innerPadding)) {
                    val (hotelImageBanner, hotelImageCarousel, hotelInfoSection) = createRefs()
                    HotelImageBanner(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .constrainAs(hotelImageBanner) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                width = Dimension.fillToConstraints

                            },

                        // filmImage ="https://image.tmdb.org/t/p/w500/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                    )

                    SmallImagesRow(
                        modifier = Modifier
                            .height(150.dp)
                            .constrainAs(hotelImageCarousel) {
                                top.linkTo(hotelImageBanner.bottom, margin = (-50).dp)
                                start.linkTo(hotelImageBanner.start)
                                end.linkTo(hotelImageBanner.end)
                                width = Dimension.fillToConstraints
                            }
                    )

                    HotelInfo(
                        modifier = Modifier
                            .height(650.dp)
                            .fillMaxSize()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                            )
                            .constrainAs(hotelInfoSection) {
                                top.linkTo(hotelImageCarousel.bottom, margin = (-50).dp)
                                start.linkTo(hotelImageCarousel.start)
                                end.linkTo(hotelImageCarousel.end)
                                width = Dimension.fillToConstraints

                            }
                    )
                }
            }

        }
    }
}


@Composable
fun HotelInfo(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ),


        ) {
        item {
            HotelInfoSection(modifier = Modifier)
        }
        item {
            RoomInfoSection(modifier = Modifier)
        }
        item {
            AmenitiesSection()
        }

        item {
            HotelDescriptionSection()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHotelDetailScreen2() {
    HoteliniTheme {
        HotelDetailsScreen()
    }
}
