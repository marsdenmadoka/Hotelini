package com.madoka.hotelini.common.domain.model

import com.madoka.hotelini.R
import com.ramcosta.composedestinations.generated.destinations.FavoritesScreenDestination
import com.ramcosta.composedestinations.generated.destinations.HomeScreenDestination


sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val route: String,
) {
    data object Home : BottomNavItem(
        title = "Home",
        icon = R.drawable.ic_home,
        route = HomeScreenDestination.route
    )
    data object Search: BottomNavItem(
        title = "Search",
        icon = R.drawable.ic_search,
       route = ""// SearchScreenDestination.route,
    )
    data object Favorites: BottomNavItem(
        title = "Favorites",
        icon = R.drawable.ic_star,
        route =   FavoritesScreenDestination.route
    )
}
