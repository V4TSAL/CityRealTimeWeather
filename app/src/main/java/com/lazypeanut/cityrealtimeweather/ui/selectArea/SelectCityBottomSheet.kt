package com.lazypeanut.cityrealtimeweather.ui.selectArea

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lazypeanut.cityrealtimeweather.ui.components.PreviewContainer
import com.lazypeanut.cityrealtimeweather.ui.selectArea.components.SelectAreaItem
import com.lazypeanut.cityrealtimeweather.utils.CityInformation
import com.lazypeanut.cityrealtimeweather.utils.supportedCityList

@Composable
fun SelectCityListView(
    modifier: Modifier = Modifier,
    cityList: List<CityInformation>? = null,
    onTap: (Int) -> Unit = {}
) {
    cityList?.let {
        LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(6.dp)) {
            itemsIndexed(it, key = { index, item -> "$index _ ${item.cityName}" }) { index, item ->
                SelectAreaItem(
                    isSelected = item.isSelected,
                    cityName = item.cityName,
                    numberOfStations = "${item.totalCities}",
                    onTap = {
                        onTap(index)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SelectCityListViewPreview() {
    PreviewContainer {
        SelectCityListView(
            cityList = supportedCityList
        )
    }
}

