package com.madoka.hotelini.home.presentation


/*
@Preview(showBackground = true)
@Composable
fun HotelDetailsScreen1() {
    HotelDetailScreenContent()
}


@Composable
fun HotelDetailScreenContent() {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Scaffold(
        topBar = {
            DetailsActions(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onEvents = {}
            )
        }

    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        HotelImageBanner1(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                        SmallImagesRow1(
                            modifier = Modifier
                                .height(130.dp)
                                .fillMaxWidth()
                                .offset(y = (-10).dp)
                        )
                        HotelInfo1(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = (-50).dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                                )
                        )
                    }

                    /* ConstraintLayout(
                         modifier = Modifier.fillMaxWidth()//Modifier.fillMaxSize()
                     ) {

                         val (hotelImageBanner, hotelImageCarousel, hotelInfoSection) = createRefs()
                         HotelImageBanner1(
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .height(250.dp)
                                 .constrainAs(hotelImageBanner) {
                                     top.linkTo(parent.top)
                                     start.linkTo(parent.start)
                                     end.linkTo(parent.end)
                                     width = Dimension.fillToConstraints
                                 },
 //
                         )

                         SmallImagesRow1(
                             modifier = Modifier
                                 .height(150.dp)
                                 .constrainAs(hotelImageCarousel) {
                                     top.linkTo(hotelImageBanner.bottom, margin = (-50).dp)
                                     start.linkTo(hotelImageBanner.start)
                                     end.linkTo(hotelImageBanner.end)
                                     width = Dimension.fillToConstraints
                                 },

                         )

                         HotelInfo1(
                             modifier = Modifier
                                 // .fillMaxSize()
                                 .fillMaxWidth()
                                 .background(
                                     color = Color.White,
                                     shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                                 )
                                 .constrainAs(hotelInfoSection) {
                                     top.linkTo(
                                         hotelImageCarousel.bottom,
                                         margin = (-50).dp
                                     ) //(-50).dp
                                     start.linkTo(hotelImageCarousel.start)
                                     end.linkTo(hotelImageCarousel.end)
                                     width = Dimension.fillToConstraints

                                 }

                         )
                     } */


                }

            }
        }

    }
}


@Composable
fun HotelInfo1(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxSize()
            .background(
                color = Color.White, shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ), verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {


        HotelInfoSection1(
            modifier = Modifier,

            )

//        RoomInfoSection1(
//            modifier = Modifier,
//        )
//
        AmenitiesSection1(
            modifier = Modifier,
        )
//
//        com.madoka.hotelini.hoteldetail.presentation.components.HotelDescriptionSection(
//            modifier = Modifier, state = state
        //     )

    }
}

@Composable
fun HotelInfoSection1(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        ViewLocationButton(
            onClick = {}, text = "View Location"
        )


        Text(
            text = "Lavebder gardens hotell",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = "icon location",
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = "No Addreeeeeeeeess",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )


            Divider(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(1.dp)
                    .height(13.dp),
                color = MaterialTheme.colorScheme.onSurface,
            )

            Icon(
                imageVector = Icons.Default.Star,
                tint = Golden,
                contentDescription = "Rating",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = " Not Rated",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 4.dp),
                color = Color.Red
            )

        }

    }
}

@Composable
fun ViewLocationButton(
    onClick: () -> Unit, text: String
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
                text = text, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        }
    }
}


@Composable
fun HotelDescriptionSection(
    modifier: Modifier = Modifier, state: HotelDetailsUiState
) {
    Column(
        modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Description",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = state.hotelDetails?.about?.title ?: "No About",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.size(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewViewLocationButton() {
    HoteliniTheme {
        ViewLocationButton(
            onClick = {}, text = "location"
        )
    }
}

@Preview
@Composable
fun HotelInfoSectionPrev() {
    HoteliniTheme {
        //HotelInfoSection(Modifier)
    }
}


@Composable
fun HotelImageBanner1(
    modifier: Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("")
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.photo1),
        contentDescription = "Image Banner",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
fun DetailsActions(
    modifier: Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CircleButton(
            onClick = { },
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


@Composable
fun AmenitiesSection1(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "What this place offers",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "More",
                color = Color(0xFF6200EE),
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }



        Text(
            text = "No offers available for now",
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}

@Composable
fun SmallImagesRow1(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .background(
                color = Color(android.graphics.Color.parseColor("#a045ff")),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            ),
        verticalArrangement = Arrangement.Bottom,
    ) {
        val imageItems = 9
        val visibleItemCount = 4

        val displayedItems = if (imageItems > visibleItemCount) {
            visibleItemCount - 1
        } else {
            imageItems
        }

        val remainingItemCount = imageItems - displayedItems

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(android.graphics.Color.parseColor("#a045ff")),
                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top,

            ) {

            items(displayedItems) { index ->
                SmallImage(modifier = modifier, imageUrl = "")

            }

            if (remainingItemCount > 0) {
                item {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(70.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(
                            Color(0xFF7B4EFF)
                        )
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "+$remainingItemCount", // Show the number of remaining items
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = androidx.compose.ui.graphics.Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SmallImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(100.dp)
            .height(70.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            4.dp
        )
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_load_placeholder),
            contentDescription = "Image Banner",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize(),
        )
    }
}


@Composable
fun Amenities(label: String, iconId: Int) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AmenitiesDisplay() {
    HoteliniTheme {
        Column {
            Amenities(label = "Anythoing", iconId = R.drawable.ic_star)
            Amenities(label = "Anythoing", iconId = R.drawable.ic_star)
            Amenities(label = "Anythoing", iconId = R.drawable.ic_star)
        }
    }
}*/