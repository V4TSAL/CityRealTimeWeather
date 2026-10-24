package com.lazypeanut.cityrealtimeweather.ui.screens.selectArea

import androidx.lifecycle.ViewModel
import com.lazypeanut.cityrealtimeweather.utils.CityInformation
import com.lazypeanut.cityrealtimeweather.utils.WeatherLocality
import com.lazypeanut.cityrealtimeweather.utils.currentSelectedCity
import com.lazypeanut.cityrealtimeweather.utils.filterLocalities
import com.lazypeanut.cityrealtimeweather.utils.selectAt
import com.lazypeanut.cityrealtimeweather.utils.supportedCityList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class SelectAreaScreenUiState(
    val cityList: List<CityInformation> = supportedCityList,
    val tempCityList: List<CityInformation> = supportedCityList,
    val currentSelectedCity: CityInformation? = supportedCityList.currentSelectedCity(),
    val localitiesForCurrentSelectedCity: List<WeatherLocality>? = supportedCityList.currentSelectedCity()?.cityLocalities,
    val searchLocalityList: List<WeatherLocality>? = supportedCityList.currentSelectedCity()?.cityLocalities,
    val localitySearchValue: String = "",
    val citySearchValue: String = ""
)

@HiltViewModel
class SelectAreaViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SelectAreaScreenUiState())
    val uiState: StateFlow<SelectAreaScreenUiState> = _uiState.asStateFlow()

    fun updateTempSelectedCity(index: Int) {
        _uiState.update {
            it.copy(tempCityList = it.cityList.selectAt(index = index))
        }
    }

    fun selectCityBottomSheetClosed(isCityConfirmed: Boolean = false) {
        if (isCityConfirmed) {
            _uiState.update {
                it.copy(
                    cityList = it.tempCityList,
                    currentSelectedCity = it.tempCityList.currentSelectedCity(),
                    localitiesForCurrentSelectedCity = it.tempCityList.currentSelectedCity()?.cityLocalities,
                    searchLocalityList = it.tempCityList.currentSelectedCity()?.cityLocalities
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    tempCityList = it.cityList
                )
            }
        }
    }

    fun selectLocality(localityId: String) {
        val newListValue =
            _uiState.value.localitiesForCurrentSelectedCity?.mapIndexed { idx, locality ->
                if (locality.localityId == localityId) {
                    locality.copy(isSelected = !locality.isSelected)
                } else {
                    locality
                }
            }
        _uiState.update {
            it.copy(
                localitiesForCurrentSelectedCity = newListValue,
                searchLocalityList = newListValue?.filterLocalities(it.localitySearchValue) ?: newListValue
            )
        }
    }

    fun searchLocality(value: String) {
        _uiState.update {
            it.copy(
                localitySearchValue = value,
                searchLocalityList = it.localitiesForCurrentSelectedCity?.filterLocalities(value) ?: it.localitiesForCurrentSelectedCity
            )
        }
    }

}