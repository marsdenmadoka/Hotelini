package com.madoka.hotelini.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.theme.Golden
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.common.presentation.theme.poppinsFamily
import com.madoka.hotelini.common.util.Resource
import com.madoka.hotelini.home.domain.model.Hotel
//import com.madoka.hotelini.home.presentation.HomeScreenContent
import kotlinx.coroutines.delay
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelCarousel(
    hotelCarousel: LazyPagingItems<Hotel>
    // hotelDetails: Hotel
) {


    when (hotelCarousel.loadState.refresh) {

        is LoadState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is LoadState.Error -> { //when error show our natural carousel
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
        }

        else -> {

            val totalItems = hotelCarousel.itemCount
            var currentItemIndex by remember { mutableIntStateOf(0) }
            var userScrolled by remember { mutableStateOf(false) }
            val carouselState = rememberCarouselState(initialItem = 0) { totalItems }

            LaunchedEffect(key1 = currentItemIndex, key2 = userScrolled) {
                while (true) {
                    delay(10_000L)
                    if (totalItems > 0) {
                        currentItemIndex = (currentItemIndex + 1) % totalItems
                        carouselState.animateScrollBy(currentItemIndex.toFloat())
                    }
                }
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
                    modifier = Modifier.fillMaxSize(),
                    itemWidth = LocalConfiguration.current.screenWidthDp.dp,
                    itemSpacing = 8.dp,
                    flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(state = carouselState)
                ) { i ->


                    hotelCarousel[i]?.let { hotel ->
                        val photoUrl = hotel.cardPhotos.firstOrNull()?.sizes?.urlTemplate
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
                            painter = rememberAsyncImagePainter(model = photoUrl),
                            contentDescription = hotel.title,
                            contentScale = ContentScale.Crop
                        )
                    }
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


            // Handle loading more items in the paging source
            when (hotelCarousel.loadState.append) {
                is LoadState.Loading -> {
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(modifier = Modifier.size(40.dp))
                    }
                }

                is LoadState.Error -> {
                    val appendError = hotelCarousel.loadState.append as LoadState.Error
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(text = "Error loading more: ${appendError.error.message}")
                    }
                }

                else -> Unit // No additional state
            }
        }
    }
}

@Composable
fun AnimatedGradientText(text: String) {
    var bigText by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (bigText) Golden else MaterialTheme.colorScheme.onSurface,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )
    val fontSize by animateFloatAsState(
        targetValue = if (bigText) 20f else 18f,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )
    LaunchedEffect(Unit) {
        while (true) {
            bigText = !bigText
            delay(1500)
        }
    }

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val animatedStartX by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 500.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val animatedEndX by infiniteTransition.animateFloat(
        initialValue = 500.0f,
        targetValue = 1000.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Text(
        text = text,
        color = color,
        fontFamily = poppinsFamily,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 14.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Red.copy(alpha = 0.6f),
                        Color.Blue.copy(alpha = 0.6f),
                        Color.Green.copy(alpha = 0.6f)
                    ),
                    startX = animatedStartX,
                    endX = animatedEndX
                ),
                shape = RoundedCornerShape(20.dp),
            )
            .padding(16.dp)
    )
}


@Preview
@Composable
fun HomeScreenCarouselPreview() {
    HoteliniTheme {
        // HotelCarousel()
    }
}