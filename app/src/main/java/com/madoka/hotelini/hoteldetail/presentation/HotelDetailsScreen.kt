package com.madoka.hotelini.hoteldetail.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
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


@OptIn(ExperimentalSharedTransitionApi::class)
@Destination<RootGraph>
@Composable
fun HotelDetailsScreen(
    hotelInfo: HotelInfo,
    viewModel: HotelDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getHotelDetails(
            hotelId = hotelInfo.id //coming from the homeScreen
        )
    }

    val hotelDetailsUiState by viewModel.hotelDetailsUiState.collectAsState()

    HotelDetailScreenContent()
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.HotelDetailScreenContent(
    animatedVisibilityScope: AnimatedVisibilityScope,
    hotelInfo: HotelInfo, //passed from our homeScreen,
    onEvents: (HotelDetailsUiEvents) -> Unit,
    detailstate: HotelDetailsUiState,
) {
    Scaffold(
        modifier = Modifier.sharedBounds(
            sharedContentState = rememberSharedContentState(key = "${hotelInfo.id}"),
            animatedVisibilityScope = animatedVisibilityScope,
        ),
        topBar = {
            DetailsActions(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onEvents = onEvents
            )
        }

    ) { innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
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
                        hotelImage = ""
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
                        hotelInfo = hotelInfo,
                        state = detailstate,
                        modifier = Modifier
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
fun HotelInfo(
    modifier: Modifier = Modifier,
    hotelInfo: HotelInfo,
    state: HotelDetailsUiState,
) {

    Column(
        modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ),


        ) {
        // item {
        HotelInfoSection(
            modifier = Modifier,
            state = state
        )
        // }
        //item {
        RoomInfoSection(modifier = Modifier)
        //}
        //item {
        AmenitiesSection(state = state)
        // }
        //item {
        HotelDescriptionSection(secondaryInfo = hotelInfo.secondaryInfo)
        //}
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHotelDetailScreen2() {
    HoteliniTheme {
        //HotelDetailsScreen()
    }
}
