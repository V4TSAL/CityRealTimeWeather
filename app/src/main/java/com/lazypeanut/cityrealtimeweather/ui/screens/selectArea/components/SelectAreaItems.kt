package com.lazypeanut.cityrealtimeweather.ui.screens.selectArea.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.lazypeanut.cityrealtimeweather.ui.components.PreviewContainer
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun SelectAreaItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    cityName: String? = null,
    numberOfStations: String? = null,
    cardColor: Color = AppTheme.colors.surfaceContainer,
    cityFontColor: Color = AppTheme.colors.onSurface,
    numberOfStationsFontColor: Color = AppTheme.colors.onSurfaceVariant,
    onTap: () -> Unit = {}
) {
    CustomContainer(
        modifier = modifier.fillMaxWidth(),
        containerColor = cardColor,
        borderColor = if (isSelected) AppTheme.colors.borderActive else AppTheme.colors.outline
    ) {
        Row(
            modifier = Modifier
                .clickable{
                    onTap()
                }
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
private fun SelectAreaItemPreview() {
    PreviewContainer {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SelectAreaItem(cityName = "Bengaluru", numberOfStations = "25")
            SelectAreaItem(cityName = "Bengaluru", numberOfStations = "25", isSelected = true)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SelectAreaItem(
                    cityName = "HSR Layout",
                    isSelected = true,
                    modifier = Modifier.weight(1f)
                )
                SelectAreaItem(
                    cityName = "BTM LAYOUT",
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SelectAreaItem(
                    cityName = "JP NAGAR",
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )
                SelectAreaItem(
                    cityName = "JAYANAGAR",
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}