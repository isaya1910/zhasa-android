package com.zhasaApp.ui.navigation

import com.zhasaApp.R

sealed class RootNavigationModel(val route: String) {
    object Splash : RootNavigationModel(route = "splash")
    object Login : RootNavigationModel(route = "login")
    object Main : RootNavigationModel(route = "main")
}

sealed class BottomMenuNavigationModel(val title: Int, val icon: Int?, val route: String) {
    object Home : BottomMenuNavigationModel(title = R.string.home, icon = R.drawable.ic_home, route = "home")
    object Branch : BottomMenuNavigationModel(title = R.string.branch, icon = R.drawable.ic_home, route = "branch")
    object Analytics : BottomMenuNavigationModel(title = R.string.analytics, icon = R.drawable.ic_home, route = "analytics")
}
