package com.lazypeanut.cityrealtimeweather.ui.theme

import androidx.compose.ui.graphics.Color

// Raw palette values. Do not reference these from UI code — use
// MaterialTheme.colorScheme.* or AppTheme.colors.* so screens follow the theme.

// Neutral border & outline
internal val Outline = Color(0xFF2A2F38)               // Standard component borders, card edges, modal outlines
internal val OutlineVariant = Color(0xFF1E2229)        // Subtle borders, hairlines, container dividers
internal val BorderSubtle = Color(0xFF181B21)          // Ultra-faint boundaries and inactive dividers
internal val BorderDefault = Color(0xFF232832)         // Default border for list cards, inputs, station tiles
internal val BorderStrong = Color(0xFF3B4352)          // High-contrast / active neutral hover states
internal val BorderActive = Color(0xFF00E5FF)          // Highlighted / selected accent border

// Surface hierarchy (darkest → brightest)
internal val SurfaceContainerLowest = Color(0xFF080A0D) // Deepest background / app canvas floor
internal val SurfaceDim = Color(0xFF0C0E12)             // Recessed areas and modal backdrops
internal val Surface = Color(0xFF111317)                // Standard base page background
internal val SurfaceContainerLow = Color(0xFF14171D)    // Inset telemetry sections and search fields
internal val SurfaceContainer = Color(0xFF1A1D24)       // Standard card background
internal val SurfaceContainerHigh = Color(0xFF20242C)   // Elevated sheets, dropdowns, active cards
internal val SurfaceBright = Color(0xFF242830)          // Highlighted interactive elements

// Text
internal val OnSurface = Color(0xFFF1F5F9)             // Primary headings and readings
internal val OnSurfaceVariant = Color(0xFF94A3B8)      // Secondary labels, sensor statuses, units
internal val OnSurfaceMuted = Color(0xFF64748B)        // Tertiary timestamps and helper metadata

// Accent & semantic states
internal val Primary = Color(0xFF00E5FF)               // Electric cyan telemetry accent
internal val Success = Color(0xFF10B981)
internal val Warning = Color(0xFFF59E0B)
internal val Error = Color(0xFFEF4444)
internal val Info = Color(0xFF38BDF8)
