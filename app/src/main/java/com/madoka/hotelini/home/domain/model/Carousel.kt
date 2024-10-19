package com.madoka.hotelini.home.domain.model

import androidx.annotation.DrawableRes
import com.madoka.hotelini.R


data class CarouselItem(
    @DrawableRes val image: Int
)

val items = listOf(
    CarouselItem(
        image = R.drawable.photo1
    ),
    CarouselItem(
        image = R.drawable.photo2
    ),
    CarouselItem(
        image = R.drawable.photo3
    ),
    CarouselItem(
        image = R.drawable.photo4
    ),
    CarouselItem(
        image = R.drawable.photo5
    ),
    CarouselItem(
        image = R.drawable.photo6
    ),
    CarouselItem(
        image = R.drawable.photo7
    )

)
