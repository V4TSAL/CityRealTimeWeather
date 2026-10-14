package com.lazypeanut.cityrealtimeweather.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

// Material's ColorScheme is derived from AppColors only so stock Material components
// (Card, TextField, Divider, sheets) pick up our palette. UI code should not read it.
private fun AppColors.toMaterialColorScheme(): ColorScheme = darkColorScheme(
    primary = primary,
    onPrimary = surfaceContainerLowest,

    background = surface,
    onBackground = onSurface,

    surface = surface,
    onSurface = onSurface,
    onSurfaceVariant = onSurfaceVariant,
    surfaceDim = surfaceDim,
    surfaceBright = surfaceBright,
    surfaceContainerLowest = surfaceContainerLowest,
    surfaceContainerLow = surfaceContainerLow,
    surfaceContainer = surfaceContainer,
    surfaceContainerHigh = surfaceContainerHigh,
    surfaceContainerHighest = surfaceBright,
    surfaceVariant = surfaceContainerHigh,

    outline = outline,
    outlineVariant = outlineVariant,

    error = error,
)

// The palette is dark-only, so the theme always uses it. Dynamic color is
// intentionally not used: it would replace the brand colors with wallpaper colors.
@Composable
fun CityRealTimeWeatherTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkAppColors
    CompositionLocalProvider(LocalAppColors provides colors) {
        MaterialTheme(
            colorScheme = colors.toMaterialColorScheme(),
            typography = Typography,
            content = content
        )
    }
}

/** The only entry point UI code uses for colors, e.g. `AppTheme.colors.borderDefault`. */
object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}
