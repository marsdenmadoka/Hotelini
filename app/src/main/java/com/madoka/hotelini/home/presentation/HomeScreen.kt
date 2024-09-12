package com.madoka.hotelini.home.presentation

import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme

@Composable
fun HomeScreen() {

}


@Composable
fun HomeScreenContent() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = {
                    Column {
                        Image(
                            painterResource(id = R.drawable.hotelini),
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 100.dp, height = 100.dp)
                                .padding(8.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() {
    HoteliniTheme {
        HomeScreenContent()
    }
}



