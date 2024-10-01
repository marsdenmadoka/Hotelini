package com.madoka.hotelini.home.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.permissions.ExperimentalPermissionsApi
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
import com.madoka.hotelini.common.domain.model.RestaurantItem
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.home.domain.model.Restaurant
import com.madoka.hotelini.home.presentation.components.HotelCarousel
import com.madoka.hotelini.home.presentation.components.NearbyHotel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@Destination<RootGraph>(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
) {

    HomeScreenContent()
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun HomeScreenContent(

) {
    val context = LocalContext.current

    Places.initialize(context, BuildConfig.MAPS_API_KEY)
    val placesClient = Places.createClient(context)
    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    // To create an instance of the fused Location Provider Client
    val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    var latitude by remember {
        mutableStateOf(0.0)
    }
    var longitude by remember {
        mutableStateOf(0.0)
    }
    var showMap by remember {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Any()) {
        scope.launch {
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
            try {
                val locationResult = fusedLocationClient.getCurrentLocation(
                    Priority.PRIORITY_HIGH_ACCURACY,
                    CancellationTokenSource().token
                )
                locationResult.addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        latitude = location.latitude
                        longitude = location.longitude
                        showMap = true
                    }
                }

            } catch (e: Exception) {
                Toast.makeText(context, "Error Fetching Location", Toast.LENGTH_LONG).show()
            }
        }

        if (showMap) {
            //showHome screenContent
            HomeScreenScaffold()
        } else {

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                androidx.compose.material3.LinearProgressIndicator(color = Green) //loading
            }


        }

    }


}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun HomeScreenScaffold(
    state: HomeUiState,
    onEvent: (HomeUiEvents) -> Unit,
) {

    val restaurants = state.restaurants.collectAsLazyPagingItems()


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
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        PullToRefreshBox(
            modifier = Modifier
                .fillMaxSize(),
            isRefreshing = false,
            onRefresh = {
                // onEvent(HomeUiEvents.OnPullToRefresh)
            }
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize())
            {
                item {
                    HotelCarousel()

                }
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "GET TO FIND YOUR NEAREST HOTELS",
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                }

                item {
                 // items(restaurants.itemCount) {}

                    NearbyHotel()
                    // NearbyHotel(state=restaurants, ImgUrl = )
                }

                // }
//                gridItems(
//                    data = ,
//                    columnCount = 2,
//                    horizontalArrangement = Arrangement.spacedBy(8.dp),
//                    modifier = Modifier.padding(horizontal = 16.dp
//                ){ itemdata ->
//
//                }

            }

        }
    }

}


fun Restaurant.toRestaurantItem(

) = RestaurantItem(
    averageRating = averageRating,
    heroImgUrl,
    name,
    userReviewCount

)


@Preview
@Composable
fun HomeScreenContentPreview() {
    HoteliniTheme {
        // HomeScreenContent()
    }
}

//@Preview
//@Composable
//fun HomeScreenContentPreview1() {
//
//    Box(
//        Modifier
//            .fillMaxWidth()
//            .height(205.dp)
//    ) {
//        Image(
//            modifier = Modifier
//                .fillMaxSize()
//                .animateContentSize(),
//            painter = painterResource(id = R.drawable.ic_load_error),
//            contentDescription = "item loader",
//            contentScale = ContentScale.Crop
//        )
//
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .padding(horizontal = 12.dp, vertical = 8.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Text(
//                text = "Hello",
//                color = Color.White,
//                fontSize = 22.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(top = 14.dp)
//            )
//        }
//
//    }
//}