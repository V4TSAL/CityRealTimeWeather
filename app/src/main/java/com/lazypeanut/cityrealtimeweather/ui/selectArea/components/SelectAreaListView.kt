package com.lazypeanut.cityrealtimeweather.ui.selectArea.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lazypeanut.cityrealtimeweather.ui.components.PreviewContainer
import com.lazypeanut.cityrealtimeweather.utils.CityInformation
import com.lazypeanut.cityrealtimeweather.utils.WeatherLocality
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

@Composable
fun SelectLocalityGridView(
    modifier: Modifier = Modifier,
    localityList: List<WeatherLocality>? = null,
    onTap: (String) -> Unit = {}
) {
    localityList?.let {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(count = 2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(it, key = { index, item -> "${item.localityId}" }) { index, item ->
                SelectAreaItem(
                    isSelected = item.isSelected,
                    cityName = item.localityName,
                    numberOfStations = null,
                    onTap = {
                        onTap(item.localityId)
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

@Preview
@Composable
private fun SelectCityGridViewPreview() {
    PreviewContainer {
        SelectLocalityGridView(
            localityList = supportedCityList[0].cityLocalities
        )
    }
}

