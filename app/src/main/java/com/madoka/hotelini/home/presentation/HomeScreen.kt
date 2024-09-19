package com.madoka.hotelini.home.presentation

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults.contentWindowInsets
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.madoka.hotelini.common.presentation.components.StarRatingBar
import com.madoka.hotelini.common.presentation.components.gridItems
import com.madoka.hotelini.common.presentation.theme.DarkSurface
import com.madoka.hotelini.common.presentation.theme.Golden
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import com.madoka.hotelini.common.presentation.theme.flix_color_translucent_black
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import kotlin.math.min
import kotlin.math.roundToInt


@Destination<RootGraph>(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
) {

    HomeScreenContent()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent() {

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
                .fillMaxSize()
                .padding(innerPadding),
            isRefreshing = false,
            onRefresh = { }
        )
        {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),

            )
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

                item{
                    NearbyHotel()
                }
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

    var currentItemIndex by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = currentItemIndex) {
        while (true) {
            delay(10_000L)
            currentItemIndex = (currentItemIndex + 1) % items.size
        }
    }
    val animatedIndex by animateDpAsState(targetValue = currentItemIndex.toFloat().dp, label = "")


    HorizontalUncontainedCarousel(
        state = rememberCarouselState { items.size },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        itemWidth = LocalConfiguration.current.screenWidthDp.dp,
        itemSpacing = 8.dp,
        // contentPadding = PaddingValues(start = 16.dp),
    ) { i ->
        val item = items[animatedIndex.value.roundToInt()]
        Box(
            Modifier
                .fillMaxWidth()
                .height(205.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .maskClip(MaterialTheme.shapes.extraLarge)
                    .animateContentSize(),
                painter = painterResource(id = item.imageResId),
                contentDescription = item.contentDescription,
                contentScale = ContentScale.Crop
            )

            Text(
                text = item.contentDescription,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 14.dp)
                    .align(Alignment.Center)
            )
        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun NearbyHotel() {

    FlowRow(
        Modifier
            .fillMaxSize(),
//            .fillMaxWidth(1f)
//            .wrapContentHeight(align = Alignment.Top),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
         verticalArrangement = Arrangement.spacedBy(16.dp),
        maxItemsInEachRow = 2
    ) {


//    }
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    )
//    {
        repeat(8){
            NearbyHotelItem(onClickItem = {})
        }




        }
    }


@Composable
fun NearbyHotelItem(
    onClickItem: () -> Unit
) {

    val defaultDominantTextColor = MaterialTheme.colorScheme.onSurface
    val dominantColor = MaterialTheme.colorScheme.surface
    val dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    val dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }

    Card(
        modifier = Modifier
            //.size(itemSize)
            //.width(250.dp)
            //.height(250.dp)
            //.weight(1f, true)
           // .size(180.dp,200.dp)
            .width(180.dp)
            .height(200.dp)
//            .fillMaxWidth()
//            .aspectRatio(1f) // Keep grid items square
            .clickable {
                onClickItem()

            },

        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {

        Box(modifier = Modifier
            .clickable { onClickItem() }
        ) {
            //region Movie Cover Imag

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_load_placeholder),
                error = painterResource(id = R.drawable.ic_load_error),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .background(color = Color.Gray)
                    .align(Alignment.Center)

            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                dominantColor
                            )
                        )
                    )
            )
            //endregion

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier,
                    text = "Unknown movie",
                    fontSize = 18.sp,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    color = dominantTextColor
                )
                RatingBar(
                    modifier = Modifier,
                    value = 3.5.toFloat(),
                    config = RatingBarConfig()
                        .activeColor(Golden)
                        .inactiveColor(DarkSurface)
                        .stepSize(StepSize.HALF)
                        .isIndicator(true)
                        .stepSize(StepSize.HALF)
                        .numStars(5)
                        .isIndicator(true)
                        .size(16.dp)
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {},
                    onRatingChanged = {}
                )

                Text(
                    modifier = Modifier,
                    text = "14 kiloMetres",
                    fontSize = 14.sp,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    color = dominantSubTextColor
                )

            }

        }


    }
}


@Preview
@Composable
fun HomeScreenContentPreview() {
    HoteliniTheme {
        HomeScreenContent()
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