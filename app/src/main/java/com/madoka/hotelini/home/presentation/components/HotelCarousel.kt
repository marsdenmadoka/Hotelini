package com.madoka.hotelini.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
//import com.madoka.hotelini.home.presentation.HomeScreenContent
import kotlinx.coroutines.delay
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelCarousel() {
    data class CarouselItem(
        val id: Int,
        @DrawableRes val imageResId: Int,
        val contentDescription: String
    )

    val items = remember {
        listOf(
            CarouselItem(0, R.drawable.ic_load_error, "cupcake"),
            CarouselItem(1, R.drawable.ic_load_placeholder, "donut"),
            CarouselItem(2, R.drawable.video_call, "eclair"),
            CarouselItem(3, R.drawable.hotelini, "froyo"),
            CarouselItem(4, R.drawable.ic_1, "gingerbread"),
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

    val animatedIndex by animateDpAsState(targetValue = currentItemIndex.toFloat().dp, label = "")

    HorizontalUncontainedCarousel(
        state = carouselState,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        itemWidth = LocalConfiguration.current.screenWidthDp.dp,
        itemSpacing = 8.dp,
    ) { i ->
        val item = items[animatedIndex.value.roundToInt()]

        val defaultDominantTextColor = MaterialTheme.colorScheme.onSurface
        val dominantColor = MaterialTheme.colorScheme.surface
        val dominantTextColor by remember { mutableStateOf(dominantColor) }
        val dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }
        Box(
            Modifier
                .fillMaxWidth()
                .height(205.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .maskClip(MaterialTheme.shapes.extraLarge)
                    .animateContentSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.surface, Color.Yellow
                                //,MaterialTheme.colorScheme.surface
                                // Color.Transparent,MaterialTheme.colorScheme.background
                            )
                        )
                    ),
                painter = painterResource(id = item.imageResId),
                contentDescription = item.contentDescription,
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = item.contentDescription,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 14.dp)

                )


            }

        }

    }
}

@Preview
@Composable
fun HomeScreenCarouselPreview() {
    HoteliniTheme {
        HotelCarousel()
    }
}
