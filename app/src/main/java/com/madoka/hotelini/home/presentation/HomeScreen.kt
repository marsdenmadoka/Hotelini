package com.madoka.hotelini.home.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.libraries.places.api.Places
import com.madoka.hotelini.BuildConfig
import com.madoka.hotelini.R
import com.madoka.hotelini.common.Location.HandleRequest
import com.madoka.hotelini.common.Location.PermissionDeniedContent
import com.madoka.hotelini.common.domain.model.toHotelInfo
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.common.util.Resource
import com.madoka.hotelini.home.domain.model.Hotel
import com.madoka.hotelini.home.presentation.components.HotelCarousel
import com.madoka.hotelini.home.presentation.components.NearbyHotelItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.HotelDetailsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import kotlin.math.max


@Destination<RootGraph>(start = true)
@Composable
fun HomeScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeUiState by viewModel.homeUiState.collectAsState()

    var latitude by remember {
        mutableDoubleStateOf(0.0)
    }
    var longitude by remember {
        mutableDoubleStateOf(0.0)
    }

    HomeScreenContent(
        state = homeUiState,
        animatedVisibilityScope = animatedVisibilityScope,
        onEvent = { homeUiEvents ->
            when (homeUiEvents) {
                HomeUiEvents.NavigateBack -> {
                    navigator.navigateUp()
                }

                is HomeUiEvents.NavigateToHotelDetails -> {
                    navigator.navigate(
                        HotelDetailsScreenDestination(
                            hotel = homeUiEvents.hotel
                        )
                    )
                }

                HomeUiEvents.OnPullToRefresh -> {
                    viewModel.refreshAllData(latitude, longitude)
                }
            }
        },
        onLocationUpdated = { lat, long ->
            latitude = lat
            longitude = long
        }
    )
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreenContent(
    state: HomeUiState,
    viewModel: HomeViewModel = hiltViewModel(),
    animatedVisibilityScope: AnimatedVisibilityScope,
    onEvent: (HomeUiEvents) -> Unit,
    onLocationUpdated: (Double, Double) -> Unit
) {
    val context = LocalContext.current

    // Initialize Google Places
    Places.initialize(context, BuildConfig.MAPS_API_KEY)
    val placesClient = Places.createClient(context)

    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    var getLatLong by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()


    // Check location permission and request if needed
    LaunchedEffect(Unit) {
        if (permissionState.status.isGranted.not()) {
            permissionState.launchPermissionRequest()
        }
    }

    //making sure the location is on
    HandleRequest(
        permissionState = permissionState,
        deniedContent = { shouldShowRationale ->
            PermissionDeniedContent(
                rationaleMessage = "We apologize for the inconvenience, but unfortunately this " +
                        "permission is required to use the app",
                shouldShowRationale = shouldShowRationale
            ) { permissionState.launchPermissionRequest() }
        }
    ) {
        //check to see if permission is available
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            LaunchedEffect(Unit) {
                scope.launch {
                    try {
                        val locationResult = fusedLocationClient.getCurrentLocation(
                            Priority.PRIORITY_HIGH_ACCURACY,
                            CancellationTokenSource().token
                        )
                        locationResult.addOnSuccessListener { location: Location? ->
                            if (location != null) {
                                val lat = location.latitude
                                val long = location.longitude
                                getLatLong = true

                                onLocationUpdated(lat, long)
                                viewModel.getNearestHotels(lat, long)
                                Toast.makeText(context, "$lat /n $long", Toast.LENGTH_LONG).show()
                            }
                        }

                    } catch (e: Exception) {
                        Toast.makeText(context, "Error Fetching Location", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


        if (getLatLong) {
            HomeScreenScaffold(state = state, onEvent = onEvent)
        } else {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                androidx.compose.material3.LinearProgressIndicator(color = Green) //loading
            }

        }

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenScaffold(
    state: HomeUiState,
    onEvent: (HomeUiEvents) -> Unit,
    //animatedVisibilityScope: AnimatedVisibilityScope,
) {

    val context = LocalContext.current
    val hotels = state.nearestHotels.collectAsLazyPagingItems()
    val carouselState = state.carousel.collectAsState(null).value ?: return


    val lazyRowScrollState = rememberLazyListState()
    var scrollOffset by remember { mutableStateOf(0f) }

    val carouselHeightPx = with(LocalDensity.current) { 200.dp.toPx() }
    val collapseRange = carouselHeightPx * 0.6f

    Scaffold(
        topBar = {
            StandardToolbar(
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painterResource(id = R.drawable.hotelini),
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 100.dp, height = 100.dp)
                                .padding(8.dp)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            )
        }
    ) { innerPadding ->
        PullToRefreshBox(
            modifier = Modifier
                .fillMaxSize(),
            isRefreshing = false,
            onRefresh = {
                onEvent(HomeUiEvents.OnPullToRefresh)
            }
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                val carouselAlpha = max(1f, 1 - (scrollOffset / collapseRange))
                val carouselHeight = max(0.dp, 200.dp - (scrollOffset / 5).dp)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(carouselHeight)
                        .alpha(carouselAlpha)
                ) {

                    HotelCarousel(hotelCarousel = carouselState)
                }
                LazyColumn(
                    state = lazyRowScrollState,
                    modifier = Modifier.onGloballyPositioned {
                        scrollOffset = lazyRowScrollState.firstVisibleItemScrollOffset.toFloat()
                    }
                ) {
                    items(hotels.itemCount) { index ->
                        hotels[index]?.let { hotel ->
                            val distanceToHotel =
                                state.hotelDistances[hotel.title] ?: "Unknown distance"
                            PagedFlowRow(items = hotels, modifier = Modifier.fillMaxWidth(),
                                content = {
                                    NearbyHotelItem(
                                        modifier = Modifier
                                            .clickable {
                                                onEvent(
                                                    HomeUiEvents.NavigateToHotelDetails(
                                                        hotel = it.toHotelInfo()
                                                    )
                                                )
                                            },
                                        hotelDetails = it,
                                        distanceToHotel = distanceToHotel
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T : Any> PagedFlowRow(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<T>,
    content: @Composable (T) -> Unit,
) {

    FlowRow(
        Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        maxItemsInEachRow = 2
    ) {

        items.itemSnapshotList.items.forEach { item ->
            if (item != null) {
                content(item)
            }
        }

        items.loadState.let { loadState ->
            when {
                loadState.refresh is LoadState.Loading -> {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterVertically),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        CircularProgressIndicator(
                            strokeWidth = 2.dp,
                        )
                    }
                }


                loadState.refresh is LoadState.NotLoading && items.itemCount < 1 -> {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterVertically),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "No data available",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                loadState.refresh is LoadState.Error -> {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterVertically),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = when ((loadState.refresh as LoadState.Error).error) {
                                is HttpException -> {
                                    "Oops, something went wrong! restart application"
                                }

                                is IOException -> {
                                    "Couldn't reach server, check your internet connection! \n" +
                                            "and restart application"
                                }

                                else -> {
                                    "Unknown error occurred restart application"
                                }
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }


                loadState.append is LoadState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.Center),
                            strokeWidth = 2.dp,
                        )
                    }

                }

                loadState.append is LoadState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "An error occurred",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                        )
                    }

                }
            }

        }

    }

}


@Preview
@Composable
fun HomeScreenContentPreview() {
    HoteliniTheme {
        //HomeScreenContent()
    }
}













