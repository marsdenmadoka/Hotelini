package com.madoka.hotelini.common.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.location.Location
import android.net.Uri
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.*


val currentDate: String = SimpleDateFormat(
    "yyyy-MM-dd",
    Locale.getDefault()
).format(Date())


fun calculateDistanceBetween(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {

    val r = 6371e3 // Earth's radius in meters
    val phi1 = Math.toRadians(lat1)
    val phi2 = Math.toRadians(lat2)

    val deltaPhi = Math.toRadians(lat2 - lat1)
    val deltaLambda = Math.toRadians(lon2 - lon1)

    val a = sin(deltaPhi / 2) * sin(deltaPhi / 2) +
            cos(phi1) * cos(phi2) *
            sin(deltaLambda / 2) * sin(deltaLambda / 2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return r * c

}

fun calculateDistance(currentLocation: LatLng, nearestHotel: LatLng): Double {
    val results = FloatArray(1)
    Location.distanceBetween(
        currentLocation.latitude, currentLocation.longitude,
        nearestHotel.latitude, nearestHotel.longitude, results
    )
    return results[0].toDouble()
}


object PaletteGenerator {
    fun generateImagePalette(imageDrawable: Drawable, onGenerated: (Palette.Swatch) -> Unit) {
        val bitmap = (imageDrawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bitmap).maximumColorCount(24).generate { palette ->
            val vibrantSwatch = palette?.vibrantSwatch
            val dominantSwatch = palette?.vibrantSwatch

            if (vibrantSwatch != null) {
                onGenerated(vibrantSwatch)
            } else if (dominantSwatch != null) {
                onGenerated(dominantSwatch)
            }
        }
    }
}


fun openMap(context: Context, latitude: Double, longitude: Double) {
    val gmmIntentUri = Uri.parse("google.navigation:q=$latitude,$longitude")
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.setPackage("com.google.android.apps.maps")

    // Check if Google Maps is available before starting the activity
    if (mapIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(mapIntent)
    } else {
        Toast.makeText(context, "Google Maps is not installed.", Toast.LENGTH_SHORT).show()
    }
}





/*
data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    val contentDescription: String
)

val items = remember {
listOf(
    CarouselItem(0, R.drawable.photo1, "cupcake"),
    CarouselItem(1, R.drawable.photo2, "donut"),
    CarouselItem(2, R.drawable.photo3, "eclair"),
    CarouselItem(3, R.drawable.photo4, "froyo"),
    CarouselItem(4, R.drawable.photo5, "gingerbread"),
    CarouselItem(4, R.drawable.photo6, "gingerbread"),
    )
}


val totalItems = items.size
var currentItemIndex by remember { mutableIntStateOf(0) }
var userScrolled by remember { mutableStateOf(false) }
val carouselState = rememberCarouselState(initialItem = 0) { totalItems }

LaunchedEffect(key1 = currentItemIndex, key2 = userScrolled) {
    delay(10_000L)
    currentItemIndex = (currentItemIndex + 1) % items.size
    carouselState.animateScrollBy(currentItemIndex.toFloat())
}

val animatedIndex by animateDpAsState(
    targetValue = currentItemIndex.toFloat().dp,
    label = ""
)

Box(
Modifier
.fillMaxWidth()
.height(205.dp)
) {
    HorizontalUncontainedCarousel(
        state = carouselState,
        modifier = Modifier
            .fillMaxSize(),
        itemWidth = LocalConfiguration.current.screenWidthDp.dp,
        itemSpacing = 8.dp,
        flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(state = carouselState)
    ) { i ->
        val item = items[animatedIndex.value.roundToInt()]
        Image(
            modifier = Modifier
                .fillMaxSize()
                .maskClip(MaterialTheme.shapes.extraLarge)
                .animateContentSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.surface
                        )
                    )
                ),
            painter = painterResource(id = item.imageResId),
            contentDescription = item.contentDescription,
            contentScale = ContentScale.Crop
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedGradientText(text = "Get All The Hotels Near You!!")
    }
}
} */