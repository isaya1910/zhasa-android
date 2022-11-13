package com.zhasaApp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zhasaApp.ui.screens.analytics.AnalyticsScreen
import com.zhasaApp.ui.screens.branch.BranchScreen
import com.zhasaApp.ui.screens.home.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationModel.Home.route) {
        composable(NavigationModel.Home.route) {
            HomeScreen()
        }
        composable(NavigationModel.Branch.route) {
            BranchScreen()
        }
        composable(NavigationModel.Analytics.route) {
            AnalyticsScreen()
        }
    }
}
