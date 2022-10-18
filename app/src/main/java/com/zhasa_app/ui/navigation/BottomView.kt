package com.zhasa_app.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zhasa_app.R
import com.zhasa_app.ui.theme.Colors


@Composable
fun MainBottomView(navController: NavController) {
    BottomNavigation(backgroundColor = Colors.BackgroundColor, contentColor = Color.White) {
        val items = listOf(
            NavigationModel.Home,
            NavigationModel.Branch,
            NavigationModel.Analytics
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { navModel ->
            BottomNavigationItem(
                onClick = {
                    navController.navigate(navModel.route) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentRoute == navModel.route,
                icon = {
                    navModel.icon?.let {
                        Icon(
                            painter = painterResource(id = navModel.icon),
                            contentDescription = ""
                        )
                    }
                },
                label = {
                    Text(text = stringResource(id = navModel.title), color = Color.White)
                })
        }
    }
}