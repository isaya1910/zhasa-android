package com.zhasa_app.ui.navigation

import com.zhasa_app.R

sealed class NavigationModel(val title: Int, val icon: Int?, val route: String) {
    object Home : NavigationModel(title = R.string.home, icon = R.drawable.ic_home, route = "home")
    object Branch: NavigationModel(title = R.string.branch, icon = R.drawable.ic_home, route = "branch")
    object Analytics : NavigationModel(title = R.string.analytics, icon = R.drawable.ic_home, route = "analytics")
}