package com.lazypeanut.cityrealtimeweather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun CustomContainer(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 12.dp,
    borderWidth: Dp = 2.dp,
    borderColor: Color = AppTheme.colors.borderDefault,
    containerColor: Color = AppTheme.colors.surfaceContainer,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .clip(shape = RoundedCornerShape(cornerRadius))
            .background(color = containerColor)
    )
    {
        content()
    }
}

@Preview
@Composable
fun CustomContainerPreview() {
    Box(modifier = Modifier.background(color = Color.Black)) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            CustomContainer(modifier = Modifier.padding(4.dp)) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .padding(12.dp)
                )
            }

            CustomContainer(
                modifier = Modifier.padding(4.dp),
                borderColor = AppTheme.colors.borderActive
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun PreviewContainer(
    modifier: Modifier = Modifier,
    containerColor: Color = AppTheme.colors.surfaceContainerLowest,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.background(containerColor)) {
        content()
    }
}