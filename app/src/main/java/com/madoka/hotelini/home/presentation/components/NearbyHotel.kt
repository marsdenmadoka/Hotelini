


package com.madoka.hotelini.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.theme.DarkSurface
import com.madoka.hotelini.common.presentation.theme.Golden


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
        repeat(8) {
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