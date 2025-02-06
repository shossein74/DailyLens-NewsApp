package com.hossein.dev.newsapp.presentation.navigator

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hossein.dev.newsapp.R
import com.hossein.dev.newsapp.presentation.navigation.Route
import com.hossein.dev.newsapp.ui.theme.LocalCustomColorsPalette

@Composable
fun CustomNavigationBar(modifier: Modifier = Modifier, currentSelectedIndex: Int, selectedColor: Color, unselectedColor: Color, onClickItem: (newIndex: Int)-> Unit) {
    Column {
        Box(modifier = Modifier.fillMaxWidth().height(1.4.dp).background(LocalCustomColorsPalette.current.colorGrey100))
        NavigationBar(
            modifier = modifier.height(74.dp),
            tonalElevation = 0.dp,
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.background,
            windowInsets = WindowInsets(left = 0.dp, right = 0.dp, top = 0.dp, bottom = 8.dp)
        ) {
            navigationBarItems.forEachIndexed { index, item ->
                val isSelected = index == currentSelectedIndex
                NavigationBarItem(
                    modifier = Modifier.padding(0.dp),
                    selected = isSelected,
                    icon = {
                        Image(
                            imageVector = ImageVector.vectorResource(if (isSelected) item.selectedDrawableId else item.unselectedDrawableId),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            item.label,
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                                color = if (isSelected) selectedColor else unselectedColor,
                            )
                        )
                    },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = selectedColor,
                        selectedIconColor = selectedColor,
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor,
                        indicatorColor = Color.Transparent,
                    ),
                    onClick = {
                        onClickItem(index)
                    },
                )
            }
        }
    }
}

val navigationBarItems = listOf(
    NavigationBarItemInfo(
        route = Route.HomeScreen.route,
        label = "Home",
        selectedDrawableId = R.drawable.selected_home,
        unselectedDrawableId = R.drawable.unselected_home
    ),
    NavigationBarItemInfo(
        route = Route.ExplorerScreen.route,
        label = "Explorer",
        selectedDrawableId = R.drawable.selected_explorer,
        unselectedDrawableId = R.drawable.unselected_explorer
    ),
    NavigationBarItemInfo(
        route = Route.BookmarkScreen.route,
        label = "Bookmark",
        selectedDrawableId = R.drawable.selected_bookmark,
        unselectedDrawableId = R.drawable.unselected_bookmark
    ),
    NavigationBarItemInfo(
        route = Route.ProfileScreen.route,
        label = "Profile",
        selectedDrawableId = R.drawable.selected_profile,
        unselectedDrawableId = R.drawable.unselected_profile
    ),
)

data class NavigationBarItemInfo(
    val label: String,
    val route: String,
    @DrawableRes val selectedDrawableId: Int,
    @DrawableRes val unselectedDrawableId: Int,
)