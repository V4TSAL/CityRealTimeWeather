package com.lazypeanut.cityrealtimeweather.ui.selectArea.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lazypeanut.cityrealtimeweather.ui.components.CustomContainer
import com.lazypeanut.cityrealtimeweather.ui.components.PreviewContainer

@Composable
fun CurrentSelectedCityItem(
    modifier: Modifier = Modifier,
    cityName: String? = null,
    onTap: () -> Unit
) {
    CustomContainer(modifier = modifier, cornerRadius = 50.dp) {
        Row(
            modifier = Modifier
                .widthIn(min = 140.dp)
                .clickable {
                    onTap()
                }
                .padding(horizontal = 14.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            cityName?.let {
                Text(it, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                tint = Color.White,
                contentDescription = "Down arrow"
            )
        }
    }
}

@Preview
@Composable
private fun CurrentSelectedCityItemPreview() {
    PreviewContainer() {
        CurrentSelectedCityItem(cityName = "Bengaluru") {}
    }
}