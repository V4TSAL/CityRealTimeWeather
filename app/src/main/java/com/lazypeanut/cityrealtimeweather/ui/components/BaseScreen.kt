package com.lazypeanut.cityrealtimeweather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colors.surfaceContainerLowest,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize().background(color = backgroundColor)){
        content()
    }
}