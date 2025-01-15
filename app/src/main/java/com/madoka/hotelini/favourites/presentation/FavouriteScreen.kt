package com.madoka.hotelini.favourites.presentation


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.madoka.hotelini.R
import com.madoka.hotelini.common.domain.model.toHotelInfo
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.madoka.hotelini.favourites.data.local.Favorite
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.HotelDetailsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay


@Destination<RootGraph>
@Composable
fun FavoritesScreen(
    navigator: DestinationsNavigator,
    viewModel: FavouritesViewModel = hiltViewModel()
) {
    var openDialog by rememberSaveable { mutableStateOf(false) }
    val favouritesHotels by viewModel.favorites.collectAsState()

    FavoritesScreenContent(
        favouritesHotels = favouritesHotels,
        showDeleteConsentDialog = openDialog,
        onNavigateBack = {
            navigator.popBackStack()
        },
        onClickDeleteAllFavorites = {
            openDialog = true
        },
        onDismissDeleteConsentDialog = {
            openDialog = false
        },
        onDeleteOneFavorite = { favourite ->
            viewModel.deleteOneFavorite(favourite)
        },
        onClickAFavorite = { favourite ->
            navigator.navigate(
                HotelDetailsScreenDestination(
                    hotelInfo = favourite.toHotelInfo()
                )
            )

        },
        onConfirmDeleteAllFavorites = {
            viewModel.deleteAllFavorites()
            openDialog = false
        }
    )
}

@Composable
private fun FavoritesScreenContent(
    favouritesHotels: List<Favorite>, //from local DB
    showDeleteConsentDialog: Boolean,
    onDismissDeleteConsentDialog: () -> Unit,
    onConfirmDeleteAllFavorites: () -> Unit,
    onNavigateBack: () -> Unit,
    onClickDeleteAllFavorites: () -> Unit,
    onDeleteOneFavorite: (Favorite) -> Unit,
    onClickAFavorite: (Favorite) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                onBackArrowClicked = onNavigateBack,
                title = {
                    Text(
                        text = "Favorites",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                showBackArrow = false,
                navActions = {
                    IconButton(
                        onClick = onClickDeleteAllFavorites
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) {

        LazyColumn(
            modifier = Modifier.padding(it),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = favouritesHotels,
                key = { favoriteMovie: Favorite ->
                    favoriteMovie.hotelId
                }
            ) { favourite ->
                SwipeToDeleteContainer(
                    item = favourite,
                    onDelete = onDeleteOneFavorite,
                    content = {
                        HotelItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp),
                            onClick = {
                                onClickAFavorite(favourite)
                            },
                            hotelItem = favourite
                        )
                    }
                )
            }
        }


        if (favouritesHotels.isEmpty()) {

            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(250.dp),
                    painter = painterResource(id = R.drawable.ic_empty_caute),
                    contentDescription = null
                )
            }
        }


        if (showDeleteConsentDialog) {
            AlertDialog(
                 modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                tonalElevation = 0.dp,
                onDismissRequest = {
                    onDismissDeleteConsentDialog()
                },
                title = {
                    Text(text = "deleteAll")
                },
                text = {
                    Text(text = "are you sure to delete all")
                },
                confirmButton = {
                    Button(
                        onClick = onConfirmDeleteAllFavorites,
                    ) {
                        Text(text = "Yes")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = onDismissDeleteConsentDialog,
                    ) {
                        Text(text = "No")
                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
        }
    }
}

@Composable
fun HotelItem(
    hotelItem: Favorite,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {//
    Card(
        modifier = modifier,
        onClick = onClick
    ) {
        Box {
            Image(
                painter = rememberImagePainter(
                    data = {},//hotelItem.image
                    builder = {
                        placeholder(R.drawable.ic_load_placeholder)
                        crossfade(true)
                    }
                ),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf(
                                Pair(0.3f, Transparent),
                                Pair(
                                    1.5f, MaterialTheme.colorScheme.background
                                )
                            )
                        )
                    )
            )

            Hoteldetails(
                title = hotelItem.title,
                releaseDate = "2/2/3",
            )
        }
    }
}

@Composable
fun Hoteldetails(
    modifier: Modifier = Modifier,
    title: String,
    releaseDate: String,

    ) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = releaseDate,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Light,
                    ),
                )
            }

        }
    }
}


@Composable
fun <T> SwipeToDeleteContainer(
    item: T,
    onDelete: (T) -> Unit,
    animationDuration: Int = 500,
    content: @Composable (T) -> Unit
) {
    var isRemoved by remember {
        mutableStateOf(false)
    }
    val state = rememberSwipeToDismissBoxState(
        confirmValueChange = { value ->
            if (value == SwipeToDismissBoxValue.EndToStart) {
                isRemoved = true
                true
            } else {
                false
            }
        }
    )

    LaunchedEffect(key1 = isRemoved) {
        if (isRemoved) {
            delay(animationDuration.toLong())
            onDelete(item)
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismissBox(
            state = state,
            backgroundContent = {
                DeleteBackground(swipeDismissState = state)
            },
            content = { content(item) },
            enableDismissFromStartToEnd = false
        )
    }
}

@Composable
fun DeleteBackground(
    swipeDismissState: SwipeToDismissBoxState
) {
    val color by animateColorAsState(
        when (swipeDismissState.targetValue) {
            SwipeToDismissBoxValue.Settled -> MaterialTheme.colorScheme.background
            else -> MaterialTheme.colorScheme.primary
        }, label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}


