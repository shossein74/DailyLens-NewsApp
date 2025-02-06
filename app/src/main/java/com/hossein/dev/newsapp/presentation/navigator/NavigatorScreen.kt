package com.hossein.dev.newsapp.presentation.navigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hossein.dev.newsapp.presentation.bookmark.BookmarkScreen
import com.hossein.dev.newsapp.presentation.bookmark.BookmarkViewModel
import com.hossein.dev.newsapp.presentation.explorer.ExplorerScreen
import com.hossein.dev.newsapp.presentation.explorer.ExplorerViewModel
import com.hossein.dev.newsapp.presentation.home.HomeScreen
import com.hossein.dev.newsapp.presentation.home.HomeViewModel
import com.hossein.dev.newsapp.presentation.navigation.Route
import com.hossein.dev.newsapp.presentation.profile.ProfileScreen
import com.hossein.dev.newsapp.presentation.profile.ProfileViewModel
import com.hossein.dev.newsapp.ui.theme.AppTheme
import com.hossein.dev.newsapp.ui.theme.LocalCustomColorsPalette

@Composable
fun NavigatorScreen() {
    val selectedColor = MaterialTheme.colorScheme.primary
    val unselectedColor = LocalCustomColorsPalette.current.colorGrey700

    val navController = rememberNavController()
    val backStack = navController.currentBackStackEntryAsState().value
    val pageIndex = rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            CustomNavigationBar(
                selectedColor = selectedColor, unselectedColor = unselectedColor,
                modifier = Modifier,
                currentSelectedIndex = pageIndex.intValue,
                onClickItem = { newIndex ->
                    pageIndex.intValue = newIndex
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
           NavHost(
               navController = navController,
               startDestination = Route.HomeScreen.route,
           ) {
               composable(Route.HomeScreen.route) {
                   val viewModel = hiltViewModel<HomeViewModel>()
                   val articles = viewModel.articles.collectAsLazyPagingItems()
                   HomeScreen(articles)
               }
               composable(Route.ExplorerScreen.route) {
                   //val viewModel = hiltViewModel<ExplorerViewModel>()
                   ExplorerScreen()
               }
               composable(Route.BookmarkScreen.route) {
                   //val viewModel = hiltViewModel<BookmarkViewModel>()
                   BookmarkScreen()
               }
               composable(Route.ProfileScreen.route) {
                   //val viewModel = hiltViewModel<ProfileViewModel>()
                   ProfileScreen()
               }
           }
        }
    }
}

@Preview
@Composable
private fun NavigatorScreenPreview() {
    AppTheme {
        NavigatorScreen()
    }
}