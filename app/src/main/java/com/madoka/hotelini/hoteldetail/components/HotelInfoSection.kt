package com.madoka.hotelini.hoteldetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.common.presentation.components.CircleButton
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import com.madoka.hotelini.common.presentation.theme.Golden


@Composable
fun HotelInfoSection(
    modifier: Modifier = Modifier,
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        ViewLocationButton(
            onClick = {},
            text = "View Location"
        )

        Text(
            text = "Wy" + "ndham Garden Washington",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.background
        )
        Row {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = "icon location",
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Annapolis Road, Washington",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.surfaceVariant
            )

        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Rating",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.surfaceBright
            )
            Divider(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(1.dp)
                    .height(13.dp),
                color = MaterialTheme.colorScheme.surface,
            )

            Icon(
                imageVector = Icons.Default.Star,
                tint = Golden,
                contentDescription = "Rating",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "4.98",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 4.dp),
                color = MaterialTheme.colorScheme.surface
            )

        }

    }
}

@Composable
fun ViewLocationButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
        modifier = Modifier
            .padding(16.dp)
            .width(250.dp)
            .height(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = text,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}


@Preview
@Composable
fun HotelDescriptionSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Description", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(
            text = "This beautiful hotel offers a luxurious stay with modern amenities such as free WiFi, pool, and parking.",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewViewLocationButton() {
    HoteliniTheme {
        ViewLocationButton(
            onClick = {},
            text = "location"
        )
    }
}

@Preview
@Composable
fun HotelInfoSectionPrev() {
    HoteliniTheme {
        HotelInfoSection(Modifier)
    }
}
