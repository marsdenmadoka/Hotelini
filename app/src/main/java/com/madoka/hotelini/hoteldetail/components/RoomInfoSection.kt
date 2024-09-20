package com.madoka.hotelini.hoteldetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RoomInfoSection( modifier: Modifier,) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RoomInfoChip("2 guest")
            Spacer(modifier = Modifier.width(4.dp))
            RoomInfoChip("1 Bath")
            Spacer(modifier = Modifier.width(4.dp))
            RoomInfoChip("1 Bedroom")
        }
        Text(text = "$150.00", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun RoomInfoChip(text: String) {
    Card(
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(
            Color.Magenta
        ),
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}