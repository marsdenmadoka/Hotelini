package com.madoka.hotelini.hoteldetail.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.madoka.hotelini.common.domain.model.HotelInfo
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.home.domain.model.items
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
import timber.log.Timber


@OptIn(ExperimentalSharedTransitionApi::class)
@Destination<RootGraph>
@Composable
fun SharedTransitionScope.HotelDetailsScreen(
    hotelInfo: HotelInfo,
    animatedVisibilityScope: AnimatedVisibilityScope,
    navigator: DestinationsNavigator,
    viewModel: HotelDetailsViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = hotelInfo.id) {
        viewModel.getHotelDetails(hotelInfo.id)
    }

    val hotelDetailsUiState by viewModel.hotelDetailsUiState.collectAsState()

    if (hotelDetailsUiState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (hotelDetailsUiState.hotelDetails != null) {
        HotelDetailScreenContent(animatedVisibilityScope = animatedVisibilityScope,
            detailState = hotelDetailsUiState,
            hotelInfo = hotelInfo,
            onEvents = { hotelDetailsEvents ->
                when (hotelDetailsEvents) {
                    HotelDetailsUiEvents.NavigateBack -> {
                        navigator.navigateUp()
                    }

                    else -> {}
                }
            })
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Error: ${hotelDetailsUiState.error ?: "Unknown error"}")
        }
    }
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.HotelDetailScreenContent(
    animatedVisibilityScope: AnimatedVisibilityScope,
    hotelInfo: HotelInfo,
    onEvents: (HotelDetailsUiEvents) -> Unit,
    detailState: HotelDetailsUiState,
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Scaffold(modifier = Modifier.sharedBounds(
        sharedContentState = rememberSharedContentState(key = "${hotelInfo.id}"),
        animatedVisibilityScope = animatedVisibilityScope,
    ), topBar = {
        DetailsActions(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), onEvents = onEvents
        )
    }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()//Modifier.fillMaxSize()
                    ) {

                        HotelImageBanner(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            hotelInfo = hotelInfo,
                            hotelDetailsState = detailState
                        )
                        SmallImagesRow(
                            modifier = Modifier
                                .height(130.dp)
                                .fillMaxWidth()
                                .offset(y = (-10).dp),
                            state = detailState,
                            imagesCarouselItems = items
                        )


                        HotelInfo(
                            hotelInfo = hotelInfo, state = detailState, modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                                )
                                .offset(y = (-50).dp)
                        )
                    }

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
                color = Color.White, shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ), verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        HotelInfoSection(
            modifier = Modifier, state = state,
            hotelInfo = hotelInfo
        )

        RoomInfoSection(
            modifier = Modifier,
            state = state
        )

        AmenitiesSection(
            modifier = Modifier, state = state
        )

        HotelDescriptionSection(
            modifier = Modifier, state = state
        )

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHotelDetailScreen2() {
    HoteliniTheme {
        //HotelDetailsScreen()
    }
}