package com.madoka.hotelini.hoteldetail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.madoka.hotelini.R
import com.madoka.hotelini.hoteldetail.presentation.HotelDetailsUiState

@Composable
fun SmallImagesRow(
    modifier: Modifier = Modifier,
    state: HotelDetailsUiState
) {
    Column(
        modifier
            .background(
                color = Color(android.graphics.Color.parseColor("#a045ff")),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            ),
        verticalArrangement = Arrangement.Bottom,
    ) {
        val photos = state.hotelDetails?.photos?: emptyList()
        val imageItems = photos.size
        val visibleItemCount = 4

        val displayedItems = if (imageItems > visibleItemCount) {
            visibleItemCount - 1
        } else {
            imageItems
        }

        val remainingItemCount = imageItems - displayedItems

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(android.graphics.Color.parseColor("#a045ff")),
                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top,

            ) {

            items(displayedItems) { index->
                SmallImage(modifier=modifier, imageUrl = photos[index].urlTemplate.replace("{width}", "100").replace("{height}", "70"))
            }


            if (remainingItemCount > 0) {
                item {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(70.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF7B4EFF)
                        )
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "+$remainingItemCount", // Show the number of remaining items
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = androidx.compose.ui.graphics.Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SmallImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(100.dp)
            .height(70.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            4.dp
        )
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_load_placeholder),
            contentDescription = "Image Banner",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize(),
        )
    }
}