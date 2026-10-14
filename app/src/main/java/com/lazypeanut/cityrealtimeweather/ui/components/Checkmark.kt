package com.lazypeanut.cityrealtimeweather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun Checkmark(
    modifier: Modifier = Modifier,
    containerColor: Color = AppTheme.colors.primary
) {
    Box(modifier = modifier
        .clip(shape = CircleShape)
        .background(color = containerColor)) {
        Icon(
            modifier = Modifier.padding(4.dp),
            imageVector = Icons.Filled.Check,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun CheckMarkPreview() {
    Checkmark()
}