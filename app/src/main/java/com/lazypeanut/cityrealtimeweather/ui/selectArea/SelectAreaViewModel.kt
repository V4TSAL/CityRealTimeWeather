package com.lazypeanut.cityrealtimeweather.ui.selectArea

import androidx.lifecycle.ViewModel
import com.lazypeanut.cityrealtimeweather.utils.CityInformation
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
    val currentSelectedCity: CityInformation? = supportedCityList.currentSelectedCity()
)

@HiltViewModel
class SelectAreaViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SelectAreaScreenUiState())
    val uiState: StateFlow<SelectAreaScreenUiState> = _uiState.asStateFlow()

    fun updateTempSelectedCity(index: Int){
        _uiState.update {
            it.copy(tempCityList = it.cityList.selectAt(index = index))
        }
    }

    fun selectCityBottomSheetClosed(isCityConfirmed: Boolean = false){
        if(isCityConfirmed){
            _uiState.update {
                it.copy(
                    cityList = it.tempCityList,
                    currentSelectedCity = it.tempCityList.currentSelectedCity()
                )
            }
        }else{
            _uiState.update {
                it.copy(tempCityList = it.cityList)
            }
        }
    }

}