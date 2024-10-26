package com.madoka.hotelini.hoteldetail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.madoka.hotelini.R
import com.madoka.hotelini.common.domain.model.HotelInfo
import com.madoka.hotelini.common.util.PaletteGenerator
import com.madoka.hotelini.hoteldetail.presentation.HotelDetailsUiState
import timber.log.Timber

@Composable
fun HotelImageBanner(
    modifier: Modifier,
    hotelInfo: HotelInfo,
    hotelDetailsState:HotelDetailsUiState
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val selectedImageUrl = hotelDetailsState.hotelDetails?.photos?.firstOrNull {
        it.urlTemplate.isNotBlank()
    }?.urlTemplate ?: " "

    Timber.d("Loading image URL: $selectedImageUrl")

    val defaultDominantColor = MaterialTheme.colorScheme.surface
    val defaultDominantTextColor = MaterialTheme.colorScheme.onSurface
    var dominantColor by remember { mutableStateOf(defaultDominantColor) }
    var dominantTextColor by remember { mutableStateOf(defaultDominantTextColor) }


    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(selectedImageUrl.replace("{width}", "400").replace("{height}", "250"))
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
            }).build()

    )

    when (val state = painter.state) {
        is AsyncImagePainter.State.Loading -> {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(205.dp), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is AsyncImagePainter.State.Success -> {
            LaunchedEffect(key1 = painter) {
                val imageDrawable = painter.imageLoader.execute(painter.request).drawable
                imageDrawable?.let {
                    PaletteGenerator.generateImagePalette(imageDrawable = it) { color ->
                        dominantColor = Color(color.rgb)
                        dominantTextColor = Color(color.titleTextColor)
                    }
                }
            }
        }

        AsyncImagePainter.State.Empty -> {
            Text(text = "Empty data")
        }

        is AsyncImagePainter.State.Error -> {
            Timber.d("Image loading error: ${state.result.throwable.message}")
        }
    }
    Image(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = Color.Gray),
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

}







/*AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
        .data(hotelImage.replace("{width}", screenWidth.toString()).replace("{height}", "250"))
        .crossfade(true)
        .build(),
    placeholder = painterResource(R.drawable.ic_load_placeholder),
    contentDescription = "Image Banner",
    contentScale = ContentScale.Crop,
    modifier = modifier.fillMaxSize(),
)   */