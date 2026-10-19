package com.lazypeanut.cityrealtimeweather.ui.selectArea

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lazypeanut.cityrealtimeweather.ui.components.BaseScreen
import com.lazypeanut.cityrealtimeweather.utils.supportedCityList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectAreaScreen(
    modifier: Modifier = Modifier,
    viewModel: SelectAreaViewModel = hiltViewModel(),
    selectAreaScreenState: SelectAreaScreenState = rememberSelectAreaScreenState()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    BaseScreen(modifier = Modifier) {
        if (selectAreaScreenState.showBottomSheet) {
            SelectCityBottomSheet(
                sheetState = selectAreaScreenState.selectCityBottomSheetState,
                cityList = uiState.tempCityList,
                bottomSheetDismissRequest = {
                    selectAreaScreenState.closeBottomSheet()
                    viewModel.selectCityBottomSheetClosed(isCityConfirmed = false)
                },
                confirmAreaSelection = {
                    selectAreaScreenState.closeBottomSheet()
                    viewModel.selectCityBottomSheetClosed(isCityConfirmed = true)
                },
                onCityItemTap = {itemIndex ->
                    viewModel.updateTempSelectedCity(itemIndex)
                }
            )
        }
        Column {
            Box(modifier = Modifier.clickable {
                selectAreaScreenState.openBottomSheet()
            }) {
                Column() {
                    Text("Hello")
                    uiState.currentSelectedCity?.let {
                        Text("Current Selected City is : ${it.cityName.orEmpty()}")
                    }
                }
            }
        }
    }
}