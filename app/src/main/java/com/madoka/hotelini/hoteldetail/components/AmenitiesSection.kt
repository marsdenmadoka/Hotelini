package com.madoka.hotelini.hoteldetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
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

@Composable
fun AmenitiesSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "What this place offers", fontWeight = FontWeight.Bold, fontSize = 16.sp)

        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        ) {
            item {
                AmenitiesIcon("Wifi", R.drawable.ic_star)
                AmenitiesIcon("Pool", R.drawable.ic_star)
                AmenitiesIcon("Free parking", R.drawable.ic_star)
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
    Column(
        modifier = Modifier
            .padding(end = 16.dp)
            .size(64.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(32.dp),
            tint = Color.Unspecified
        )
        Text(text = label, fontSize = 12.sp)
    }
}