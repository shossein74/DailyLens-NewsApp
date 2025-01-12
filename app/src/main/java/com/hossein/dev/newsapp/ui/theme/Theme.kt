package com.hossein.dev.newsapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = colorPrimaryDark,
    onPrimary = colorOnPrimaryDark,
    secondary = colorSecondaryDark,
    onSecondary = colorOnSecondaryDark,
    background = colorBackgroundDark,
    onBackground = colorOnBackgroundDark,
)

val customColorsLight = CustomColors(
    colorGrey100 = colorGrey100Light,
    colorGrey200 = colorGrey200Light,
    colorGrey300 = colorGrey300Light,
    colorGrey400 = colorGrey400Light,
    colorGrey500 = colorGrey500Light,
    colorGrey600 = colorGrey600Light,
    colorGrey700 = colorGrey700Light,

    colorSuccess = colorSuccessLight,
    colorError = colorErrorLight,
    colorWarning = colorWarningLight,

    colorSecondaryText = colorSecondaryTextLight,
    colorLinkText = colorLinkTextLight,
)

private val LightColorScheme = lightColorScheme(
    primary = colorPrimaryLight,
    onPrimary = colorOnPrimaryLight,
    secondary = colorSecondaryLight,
    onSecondary = colorOnSecondaryLight,
    background = colorBackgroundLight,
    onBackground = colorOnBackgroundLight,
)

val customColorsDark = CustomColors(
    colorGrey100 = colorGrey100Dark,
    colorGrey200 = colorGrey200Dark,
    colorGrey300 = colorGrey300Dark,
    colorGrey400 = colorGrey400Dark,
    colorGrey500 = colorGrey500Dark,
    colorGrey600 = colorGrey600Dark,
    colorGrey700 = colorGrey700Dark,

    colorSuccess = colorSuccessDark,
    colorError = colorErrorDark,
    colorWarning = colorWarningDark,

    colorSecondaryText = colorSecondaryTextDark,
    colorLinkText = colorLinkTextDark,
)

@Composable
fun NewsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColorsPalette =
        if (darkTheme) customColorsDark
        else customColorsLight


    CompositionLocalProvider(
        CustomColorsPalette provides customColorsPalette
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content,
        )
    }
}