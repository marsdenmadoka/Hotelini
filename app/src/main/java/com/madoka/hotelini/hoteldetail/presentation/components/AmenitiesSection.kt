package com.madoka.hotelini.hoteldetail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
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

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "What this place offers",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "More",
                color = Color(0xFF6200EE),
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }


        val amenities = state.hotelDetails?.about?.content?.find { it.title == "Amenities" }
        if (amenities?.content.isNullOrEmpty()) {
            Text(
                text = "No offers available for now",
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 8.dp)
            )
        } else {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                amenities?.content?.forEach { amenity ->
                    Amenities(label = amenity.title, iconId = R.drawable.ic_star)
                }

            }

        }
    }
}

@Composable
fun Amenities(label: String, iconId: Int) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AmenitiesDisplay() {
    HoteliniTheme {
        Column {
            Amenities(label = "Anythoing", iconId = R.drawable.ic_star)
            Amenities(label = "Anythoing", iconId = R.drawable.ic_star)
            Amenities(label = "Anythoing", iconId = R.drawable.ic_star)
        }
    }
}