package com.example.composeapp.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightThemeColors = lightColors(
    primary = GrayDark,
    primaryVariant = GrayDark,
    secondary = White,
    secondaryVariant = GrayDark,
    background = White,
    surface = White,
    error = Red,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
    onError = DarkRed
)

private val DarkThemeColors = darkColors(
    primary = DarkLight,
    primaryVariant = GrayLight,
    secondary = GrayLight,
    secondaryVariant = GrayDark,
    background = White,
    surface = White,
    error = Red,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    onError = DarkRed
)

@Composable
fun AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = LatoTypography
    ) {
        content()
    }
}
