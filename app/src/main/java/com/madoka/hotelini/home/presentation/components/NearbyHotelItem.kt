package com.madoka.hotelini.home.presentation.components

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.theme.DarkSurface
import com.madoka.hotelini.common.presentation.theme.Golden
import com.madoka.hotelini.common.util.PaletteGenerator
import com.madoka.hotelini.home.domain.model.Hotel
import com.madoka.hotelini.home.domain.model.items

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.NearbyHotelItem(
    modifier: Modifier = Modifier,
    hotelDetails: Hotel,
    distanceToHotel: String,
    sharedTransitionKey: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    val defaultDominantTextColor = MaterialTheme.colorScheme.onSurface
    var dominantColor = MaterialTheme.colorScheme.surface
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }
    val dominantSubTextColor by remember { mutableStateOf(dominantColor) }

    val selectedImageUrl =
        hotelDetails.cardPhotos.firstOrNull { it.sizes.urlTemplate.isNotBlank() }?.sizes?.urlTemplate
            ?:""
    /*
    * hotelDetails.cardPhotos.filter { it.sizes.urlTemplate.isNotBlank() }
            .firstOrNull { it.sizes.urlTemplate.isNotBlank() }?.sizes?.urlTemplate
            ?: painterResource(id = R.drawable.photo5)
    * */


    //hotelDetails.cardPhotos.first { it.sizes.urlTemplate.isNotBlank() }
    //.randomOrNull()?.sizes?.urlTemplate ?: ""

    //hotelDetails.cardPhotos.firstOrNull()?.sizes?.urlTemplate ?: ""

    /* hotelDetails.cardPhotos
     .filter { it.sizes.urlTemplate.isNotBlank() }
     .randomOrNull()?.sizes?.urlTemplate ?: "" */

    Card(
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
            .padding(horizontal = 4.dp),
        elevation = CardDefaults.cardElevation(8.dp), shape = RoundedCornerShape(4.dp)
    ) {
        Box {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(selectedImageUrl.replace("{width}", "400").replace("{height}", "300"))
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                    }).build()
            )

            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(205.dp), contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is AsyncImagePainter.State.Success -> {
                    LaunchedEffect(key1 = painter) {
                        val imageDrawable = painter.imageLoader.execute(painter.request).drawable
                        imageDrawable?.let {
                            PaletteGenerator.generateImagePalette(imageDrawable = it) { color ->
                                dominantColor = Color(color.rgb)
                                dominantTextColor = Color(color.titleTextColor)
                            }
                        }
                    }
                }

                AsyncImagePainter.State.Empty -> {
                    Text(text = "Empty data")
                }

                is AsyncImagePainter.State.Error -> {
                    Text(text = "Error Found")
                }
            }

            Image(
                modifier = modifier
                    .sharedElement(
                        state = rememberSharedContentState( key = sharedTransitionKey),
                        animatedVisibilityScope = animatedVisibilityScope)
                    .fillMaxSize()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .background(color = Color.Gray)
                    .align(Alignment.Center),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = hotelDetails.title.substringAfter(". ").trim(),
                    fontSize = 18.sp,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface
                )

                if (hotelDetails.bubbleRating.rating.toFloat() <= 1) {
                    Text(
                        modifier = modifier,
                        text = "Not rated",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                } else {
                    RatingBar(modifier = modifier,
                        value = hotelDetails.bubbleRating.rating.toFloat(),
                        config = RatingBarConfig().activeColor(Golden).inactiveColor(DarkSurface)
                            .stepSize(StepSize.HALF).isIndicator(true).stepSize(StepSize.HALF)
                            .numStars(5).isIndicator(true).size(16.dp)
                            .style(RatingBarStyle.HighLighted),
                        onValueChange = {},
                        onRatingChanged = {})
                }

                Text(
                    modifier = modifier,
                    text = distanceToHotel,
                    fontSize = 14.sp,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

        }
    }
}