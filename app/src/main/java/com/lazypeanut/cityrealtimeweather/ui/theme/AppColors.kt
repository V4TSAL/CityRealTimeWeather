package com.lazypeanut.cityrealtimeweather.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Single source of truth for every color token in the app.
 * UI code reads colors only through `AppTheme.colors.*`.
 * Material's ColorScheme is derived from this so stock components match.
 */
@Immutable
data class AppColors(
    // Neutral border & outline
    val outline: Color,
    val outlineVariant: Color,
    val borderSubtle: Color,
    val borderDefault: Color,
    val borderStrong: Color,
    val borderActive: Color,

    // Surface hierarchy
    val surfaceContainerLowest: Color,
    val surfaceDim: Color,
    val surface: Color,
    val surfaceContainerLow: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceBright: Color,

    // Text
    val onSurface: Color,
    val onSurfaceVariant: Color,
    val onSurfaceMuted: Color,

    // Accent & semantic states
    val primary: Color,
    val success: Color,
    val warning: Color,
    val error: Color,
    val info: Color,
)

internal val DarkAppColors = AppColors(
    outline = Outline,
    outlineVariant = OutlineVariant,
    borderSubtle = BorderSubtle,
    borderDefault = BorderDefault,
    borderStrong = BorderStrong,
    borderActive = BorderActive,

    surfaceContainerLowest = SurfaceContainerLowest,
    surfaceDim = SurfaceDim,
    surface = Surface,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceBright = SurfaceBright,

    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant,
    onSurfaceMuted = OnSurfaceMuted,

    primary = Primary,
    success = Success,
    warning = Warning,
    error = Error,
    info = Info,
)

// Defaults to the dark palette so previews without the theme wrapper still render correctly.
internal val LocalAppColors = staticCompositionLocalOf { DarkAppColors }
