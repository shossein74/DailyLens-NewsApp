package com.hossein.dev.newsapp.presentation.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hossein.dev.newsapp.R
import com.hossein.dev.newsapp.presentation.navigation.NavGraph
import com.hossein.dev.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition { viewModel.splashCondition }
        }

        val statusBarColor = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            resources.getColor(R.color.primary) else resources.getColor(R.color.primary, theme)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = statusBarColor,
                darkScrim = statusBarColor,
            )
        )

        setContent {
            NewsAppTheme {
                Box(Modifier.padding(0.dp)) {
                    NavGraph(
                        startDestination = viewModel.startDestination
                    )
                }
            }
        }
    }
}
