package com.madoka.hotelini.hoteldetail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R
import com.madoka.hotelini.hoteldetail.presentation.HotelDetailsUiState

@Composable
fun AmenitiesSection(
    modifier: Modifier = Modifier,
    state: HotelDetailsUiState
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "What this place offers",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.surface
        )
        val amenities = state.hotelDetails?.amenitiesScreen
        if (amenities.isNullOrEmpty()) {
            Text(
                text = "No offers available for now",
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 8.dp)
            )
        } else {

            LazyColumn(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {

                items(amenities){ amenity->
                    AmenitiesIcon(label = amenity.title , iconId = R.drawable.ic_star )

                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "More",
                color = Color(0xFF6200EE),
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun AmenitiesIcon(label: String, iconId: Int) {
    Row(
        modifier = Modifier
            .size(64.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.surface
        )
        Text(text = label, fontSize = 12.sp, color = MaterialTheme.colorScheme.surface)
    }
}