package com.madoka.hotelini.hoteldetail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.components.CircleButton
import com.madoka.hotelini.hoteldetail.presentation.HotelDetailsUiEvents


@Composable
fun DetailsActions(
    modifier: Modifier,
    onEvents: (HotelDetailsUiEvents) -> Unit,
    //isLiked: Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CircleButton(
            onClick = {
                onEvents(HotelDetailsUiEvents.NavigateBack)
            },
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_left),
                tint = MaterialTheme.colorScheme.onPrimary,
                contentDescription = null
            )
        }

        CircleButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = ""

            )
        }
    }
}

@Preview
@Composable
fun DetailsActionsPrev() {
    //DetailsActions(Modifier)
}
