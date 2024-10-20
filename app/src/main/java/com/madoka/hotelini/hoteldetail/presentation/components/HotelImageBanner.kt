package com.madoka.hotelini.hoteldetail.presentation.components

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
import com.madoka.hotelini.common.domain.model.HotelInfo

@Composable
fun HotelImageBanner(
    modifier: Modifier,
    hotelInfo: HotelInfo
) {

   val hotelImage = hotelInfo.cardPhotos.firstOrNull { it.sizes.urlTemplate.isNotBlank() }
        ?.sizes?.urlTemplate?: " "
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(hotelImage)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_load_placeholder),
        contentDescription = "Image Banner",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize(),
    )   



//    Image(
//        painter = painterResource(id = R.drawable.ic_load_error), // Replace with your image resources
//        contentDescription = "Image Banner",
//        contentScale = ContentScale.Crop,
//        modifier = modifier.fillMaxSize()
//    )

}