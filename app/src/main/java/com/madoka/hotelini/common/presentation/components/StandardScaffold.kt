package com.madoka.hotelini.common.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.madoka.hotelini.common.model.BottomNavItem
import com.madoka.hotelini.common.presentation.theme.HoteliniTheme


@Composable
fun StandardScaffold(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Favorites,
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {
    Scaffold(

        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    modifier = Modifier
                        .height(56.dp),
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    modifier = Modifier.size(20.dp),
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.title,
                                )
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                                )
                            },
                            alwaysShowLabel = true,
                            selected = currentDestination?.route?.contains(item.route) == true,
                            onClick = {
                                navController.navigate(item.route) {
                                    navController.graph.startDestinationRoute?.let { screenRoute ->
                                        popUpTo(screenRoute) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}

@Preview
@Composable
fun  StandardScaffoldPreview() {
    HoteliniTheme {
        val navController = rememberNavController()
        StandardScaffold(
            navController =navController,
            content = {}
        )
    }
}