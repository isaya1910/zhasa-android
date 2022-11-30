package com.zhasaApp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zhasaApp.ui.login.viewmodels.LoginViewModel
import com.zhasaApp.ui.login.views.LoginView
import com.zhasaApp.ui.main.views.MainView
import com.zhasaApp.ui.screens.analytics.AnalyticsScreen
import com.zhasaApp.ui.screens.branch.BranchScreen
import com.zhasaApp.ui.splash.models.SplashAction
import com.zhasaApp.ui.splash.viewmodels.SplashViewModel
import com.zhasaApp.ui.splash.views.SplashView
import com.zhasaApp.ui.statistic.leadingYearStatistic.views.StatisticScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    splashViewModel: SplashViewModel
) {
    NavHost(navController = navController, startDestination = RootNavigationModel.Splash.route) {
        composable(RootNavigationModel.Splash.route) {
            SplashView(navController, splashViewModel.stateFlow) {
                splashViewModel.obtainAction(SplashAction.CheckAuthState)
            }
        }

        composable(RootNavigationModel.Login.route) {
            LoginView(loginViewModel = loginViewModel)
        }

        composable(RootNavigationModel.Main.route) {
            MainView()
        }
    }
}

@Composable
fun BottomMenuNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomMenuNavigationModel.Home.route
    ) {
        composable(BottomMenuNavigationModel.Home.route) {
            StatisticScreen()
        }
        composable(BottomMenuNavigationModel.Branch.route) {
            BranchScreen()
        }
        composable(BottomMenuNavigationModel.Analytics.route) {
            AnalyticsScreen()
        }
    }
}
