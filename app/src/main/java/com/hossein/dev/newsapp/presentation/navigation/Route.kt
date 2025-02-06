package com.hossein.dev.newsapp.presentation.navigation

sealed class Route(
    val route: String
) {
    data object AppStartNavigation: Route(route = "appStartNavigation")
    data object MainNavigation: Route(route = "mainNavigation")

    data object OnBoardingScreen: Route(route = "onBoardingScreen")

    data object NavigatorScreen: Route(route = "navigatorScreen")

    data object HomeScreen: Route(route = "homeScreen")
    data object SearchScreen: Route(route = "searchScreen")
    data object DetailsScreen: Route(route = "detailsScreen")

    data object ExplorerScreen: Route(route = "explorerScreen")

    data object BookmarkScreen: Route(route = "bookmarkScreen")

    data object ProfileScreen: Route(route = "profileScreen")

}