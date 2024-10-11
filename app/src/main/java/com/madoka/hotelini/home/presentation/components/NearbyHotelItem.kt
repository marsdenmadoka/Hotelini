package com.madoka.hotelini.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
import com.madoka.hotelini.home.domain.model.Hotel

@Composable
fun NearbyHotelItem(
    modifier: Modifier = Modifier,
    hotelDetails: Hotel,
    distanceToHotel: String
) {
    val defaultDominantTextColor = MaterialTheme.colorScheme.onSurface
    val dominantColor = MaterialTheme.colorScheme.surface
    val dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    val dominantSubTextColor by remember { mutableStateOf(defaultDominantTextColor) }

    val selectedImageUrl = hotelDetails.cardPhotos
        .filter { it.sizes.urlTemplate.isNotBlank() }
        .randomOrNull()?.sizes?.urlTemplate ?: ""

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp)
            .padding(horizontal = 3.dp),
        elevation = CardDefaults.cardElevation(8.dp), shape = RoundedCornerShape(4.dp)
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(selectedImageUrl.replace("{width}", "400").replace("{height}", "300"))
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
                    text = hotelDetails.title.substringAfter(". ").trim(),
                    fontSize = 18.sp,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    color = dominantTextColor
                )

                if (hotelDetails.bubbleRating?.rating != null) {
                    RatingBar(modifier = Modifier,
                        value = hotelDetails.bubbleRating.rating.toFloat(),
                        config = RatingBarConfig().activeColor(Golden).inactiveColor(DarkSurface)
                            .stepSize(StepSize.HALF).isIndicator(true).stepSize(StepSize.HALF)
                            .numStars(5).isIndicator(true).size(16.dp)
                            .style(RatingBarStyle.HighLighted),
                        onValueChange = {},
                        onRatingChanged = {})
                } else {
                    Text(
                        modifier = Modifier,
                        text = "Not rated",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.bodySmall,
                        color = dominantSubTextColor
                    )
                }

                Text(
                    modifier = Modifier,
                    text = distanceToHotel,
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