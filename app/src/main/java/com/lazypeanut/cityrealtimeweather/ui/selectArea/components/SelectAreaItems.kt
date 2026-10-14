package com.lazypeanut.cityrealtimeweather.ui.selectArea.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lazypeanut.cityrealtimeweather.ui.components.Checkmark
import com.lazypeanut.cityrealtimeweather.ui.components.CustomContainer
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun SelectCityItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    cardColor: Color = AppTheme.colors.surfaceContainer,
    cityName: String? = null,
    numberOfStations: String? = null,
    cityFontColor: Color = AppTheme.colors.onSurface,
    numberOfStationsFontColor: Color = AppTheme.colors.onSurfaceVariant
) {
    CustomContainer(
        modifier = modifier.fillMaxWidth(),
        containerColor = cardColor,
        borderColor = if(isSelected) AppTheme.colors.borderActive else AppTheme.colors.outline
        ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 14.dp, vertical = if (isSelected) 18.dp else 22.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                cityName?.let {
                    Text(
                        it, style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = cityFontColor
                        )
                    )
                }
                numberOfStations?.let {
                    Text(
                        "•  $it Stations", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = numberOfStationsFontColor
                        )
                    )
                }
            }
            if (isSelected) {
                Checkmark()
            }
        }
    }
}

@Preview
@Composable
private fun SelectCityItemPreview() {
    Column(
        modifier = Modifier.background(color = Color.White).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SelectCityItem(cityName = "Bengaluru", numberOfStations = "25")
        SelectCityItem(cityName = "Bengaluru", numberOfStations = "25", isSelected = true)
    }
}