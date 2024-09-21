package com.madoka.hotelini.hoteldetail.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R

@Composable
fun HotelImageCarousel(modifier: Modifier = Modifier) {
    Column(
        modifier
            .background(
                color = Color(android.graphics.Color.parseColor("#a045ff")),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            ),
        verticalArrangement = Arrangement.Bottom,
    ) {
        val imageItems: Int = 7
        val visibleItemCount: Int = 4

        val displayedItems = if (imageItems > visibleItemCount) {
            visibleItemCount - 1 // Show all but the last one
        } else {
            imageItems // If items fit, display them all
        }

        val remainingItemCount = imageItems - displayedItems // Remaining items count


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
            items(displayedItems) {// Simulating three hotel images
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
                    Image(
                        painter = painterResource(id = R.drawable.ic_load_error), // Replace with your image resources
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
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