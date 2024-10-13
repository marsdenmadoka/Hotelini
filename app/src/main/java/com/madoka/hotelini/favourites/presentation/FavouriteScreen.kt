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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.madoka.hotelini.R
import com.madoka.hotelini.common.presentation.components.StandardToolbar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import kotlinx.coroutines.delay


@Preview
@Destination<RootGraph>
@Composable
fun FavoritesScreen(
  //  navigator: DestinationsNavigator,
) {
    var openDialog by rememberSaveable { mutableStateOf(false) }


    FavoritesScreenContent(
        showDeleteConsentDialog = openDialog,
        onNavigateBack = {
           // navigator.popBackStack()
        },
        onClickDeleteAllFavorites = {
            openDialog = true
        },
        onDismissDeleteConsentDialog = {
            openDialog = false
        },
        onDeleteOneFavorite = { },
        onClickAFavorite = { },
        onConfirmDeleteAllFavorites = { }
    )
}

@Composable
private fun FavoritesScreenContent(
    showDeleteConsentDialog: Boolean,
    onDismissDeleteConsentDialog: () -> Unit,
    onConfirmDeleteAllFavorites: () -> Unit,
    onNavigateBack: () -> Unit,
    onClickDeleteAllFavorites: () -> Unit,
    onDeleteOneFavorite: () -> Unit,
    onClickAFavorite: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                onBackArrowClicked = onNavigateBack,
                title = {
                    Text(
                        text = "Favorites",//stringResource(R.string.favorites),
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
            item(
                key = { }
            ) {
                SwipeToDeleteContainer(
                    item = { },
                    onDelete = {},
                    content = {
                        FilmItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp),
                            onClick = {
                                onClickAFavorite()
                            }
                        )
                    }
                )
            }
        }


//        if (favoriteFilms.isEmpty()) {

//            Column(
//                Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    modifier = Modifier
//                        .size(250.dp),
//                    painter = painterResource(id = R.drawable.ic_empty_cuate),
//                    contentDescription = null
//                )
//            }
//        }


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
                    Text(text ="deleteAll") //stringResource(R.string.delete_all_favorites))
                },
                text = {
                    Text(text = "are you sure to delete all")//stringResource(R.string.are_you_want_to_delete_all))
                },
                confirmButton = {
                    Button(
                        onClick = onConfirmDeleteAllFavorites,
                    ) {
                        Text(text = "Yes")//stringResource(R.string.yes))
                    }
                },
                dismissButton = {
                    Button(
                        onClick = onDismissDeleteConsentDialog,
                    ) {
                        Text(text ="No") //stringResource(R.string.no))
                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
        }
    }
}

@Composable
fun FilmItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        onClick = onClick
    ) {
        Box {
            Image(
                painter = rememberImagePainter(
                    data = {},
                    builder = {
                        placeholder(R.drawable.ic_load_placeholder)
                        crossfade(true)
                    }
                ),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                contentDescription = "Movie Banner"
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

            FilmDetails(
                title = "detail",
                releaseDate = "2/2/3",
            )
        }
    }
}

@Composable
fun FilmDetails(
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