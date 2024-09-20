package com.madoka.hotelini.hoteldetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.components.CircleButton
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme


@Composable
fun HotelInfoSection(
    modifier: Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircleButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
        ) {
            Text(
                text = "view Location"
            )
//            Icon(
//                painter = painterResource(id = R.drawable.ic_chevron_left),
//                tint = MaterialTheme.colorScheme.onPrimary,
//                contentDescription = null
//            )
        }


        Text(
            text = "Wy" + "ndham Garden Washington",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.background
        )
        Text(
            text = "Annapolis Road, Washington",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Rating",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Divider(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(1.dp)
                    .height(13.dp),
                color = MaterialTheme.colorScheme.onSurface,
            )

            Text(
                text = "4.98",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 4.dp),
                color = MaterialTheme.colorScheme.onSurface
            )

        }
    }
}

@Preview
@Composable
fun HotelInfoSectionPrev() {
    HoteliniTheme {
        HotelInfoSection(Modifier)
    }
}
