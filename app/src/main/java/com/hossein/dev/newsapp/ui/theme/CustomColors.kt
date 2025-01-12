package com.hossein.dev.newsapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val colorGrey100: Color = Color.Unspecified,
    val colorGrey200: Color = Color.Unspecified,
    val colorGrey300: Color = Color.Unspecified,
    val colorGrey400: Color = Color.Unspecified,
    val colorGrey500: Color = Color.Unspecified,
    val colorGrey600: Color = Color.Unspecified,
    val colorGrey700: Color = Color.Unspecified,

    val colorSuccess: Color = Color.Unspecified,
    val colorError: Color = Color.Unspecified,
    val colorWarning: Color = Color.Unspecified,
    val colorInformation: Color = Color.Unspecified,

    val colorSecondaryText: Color = Color.Unspecified,
    val colorLinkText: Color = Color.Unspecified,
)

val CustomColorsPalette = staticCompositionLocalOf { CustomColors() }
