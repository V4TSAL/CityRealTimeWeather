package com.lazypeanut.cityrealtimeweather.utils

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