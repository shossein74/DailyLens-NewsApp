package com.hossein.dev.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.hossein.dev.newsapp.presentation.navigator.NavigatorScreen
import com.hossein.dev.newsapp.presentation.onboarding.components.OnBoardingScreen
import com.hossein.dev.newsapp.presentation.onboarding.components.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route,
        ) {
            composable(
                route = Route.OnBoardingScreen.route,
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.MainNavigation.route,
            startDestination = Route.NavigatorScreen.route
        ) {
            composable(route = Route.NavigatorScreen.route) {
                NavigatorScreen()
            }
        }
    }
}