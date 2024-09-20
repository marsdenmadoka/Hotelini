package com.madoka.hotelini.hoteldetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.madoka.hotelini.R

@Composable
fun HotelImageBanner(
    modifier: Modifier,
    //filmImage: String,
) {
//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(filmImage)
//            .crossfade(true)
//            .build(),
//        placeholder = painterResource(R.drawable.ic_load_error),
//        contentDescription = "Image Banner",
//        contentScale = ContentScale.Crop,
//        modifier = modifier.fillMaxSize(),
//    )

    Image(
        painter = painterResource(id = R.drawable.ic_load_error), // Replace with your image resources
        contentDescription = "Image Banner",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )

}