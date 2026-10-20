package com.lazypeanut.cityrealtimeweather.utils

import androidx.compose.ui.text.toLowerCase
import java.util.Locale

fun List<CityInformation>.selectAt(index: Int): List<CityInformation> {
    if (index !in indices) return this
    return mapIndexed { i, city ->
        val shouldBeSelected = i == index
        if (city.isSelected == shouldBeSelected) city else city.copy(isSelected = shouldBeSelected)
    }
}

fun List<CityInformation>.currentSelectedCity(): CityInformation? {
    return this.firstOrNull {
        it.isSelected
    }
}

fun  List<WeatherLocality>.filterLocalities(searchValue: String) : List<WeatherLocality>?{
    return if(searchValue.isEmpty()){
        null
    }else{
        this.filter {
            it.localityName.lowercase(Locale.getDefault()).contains(searchValue.lowercase(Locale.getDefault()))
        }
    }
}