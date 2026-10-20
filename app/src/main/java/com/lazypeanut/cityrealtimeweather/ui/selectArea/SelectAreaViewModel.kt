package com.lazypeanut.cityrealtimeweather.ui.selectArea

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import com.lazypeanut.cityrealtimeweather.utils.CityInformation
import com.lazypeanut.cityrealtimeweather.utils.WeatherLocality
import com.lazypeanut.cityrealtimeweather.utils.currentSelectedCity
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
    val localitySearchValue: String = ""
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

    fun selectLocality(index: Int) {
        val newListValue =
            _uiState.value.localitiesForCurrentSelectedCity?.mapIndexed { idx, locality ->
                if (idx == index) {
                    locality.copy(isSelected = !locality.isSelected)
                } else {
                    locality
                }
            }
        _uiState.update {
            it.copy(
                localitiesForCurrentSelectedCity = newListValue
            )
        }
    }

    fun searchLocality(value: String) {
        val searchValue = value.toLowerCase(Locale.current)
        val filteredLocalityList = _uiState.value.localitiesForCurrentSelectedCity?.filter {
            it.localityName.toLowerCase(Locale.current).contains(searchValue)
        }
        _uiState.update {
            it.copy(
                localitySearchValue = value,
                searchLocalityList = if (searchValue.isNotEmpty()) {
                    filteredLocalityList
                } else {
                    it.localitiesForCurrentSelectedCity
                }
            )
        }
    }

}