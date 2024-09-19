package com.madoka.hotelini.hoteldetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R

@Composable
fun HotelDetailScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // 1. Image carousel
        HotelImageCarousel()

        Spacer(modifier = Modifier.height(8.dp))

        // 2. Hotel info
        HotelInfoSection()

        Spacer(modifier = Modifier.height(8.dp))

        // 3. Room info
        RoomInfoSection()

        Divider(color = Color.LightGray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(8.dp))

        // 4. Amenities Section
        AmenitiesSection()

        Spacer(modifier = Modifier.height(8.dp))

        // 5. Description Section
        HotelDescriptionSection()
    }
}

@Composable
fun HotelImageCarousel() {
    Box {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 16.dp)
        ) {
            items(3) { // Simulating three hotel images
                Card(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .width(250.dp)
                        .height(200.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(
                        4.dp)


                ) {
                    Image(
                        painter = painterResource(id =  R.drawable.ic_load_error), // Replace with your image resources
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        // Overlay for "+5" button on top of the carousel
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(32.dp)
                .size(50.dp)
                .background(Color(0xFF6200EE), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "+5", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun HotelInfoSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Wy" +
                    "ndham Garden Washington",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Annapolis Road, Washington",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "4.98",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "(237 reviews)",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun RoomInfoSection() {
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
            Color(0xFFE0E0E0)
        ),
        //  backgroundColor = Color(0xFFE0E0E0),
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

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
            .size(64.dp),
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
fun PreviewHotelDetailScreen1() {
    HotelDetailScreen()
}
