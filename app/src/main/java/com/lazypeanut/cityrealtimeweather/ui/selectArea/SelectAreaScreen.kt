package com.lazypeanut.cityrealtimeweather.ui.selectArea

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lazypeanut.cityrealtimeweather.ui.components.BaseScreen
import com.lazypeanut.cityrealtimeweather.ui.selectArea.bottomSheet.SelectCityBottomSheet
import com.lazypeanut.cityrealtimeweather.ui.selectArea.components.CurrentSelectedCityItem
import com.lazypeanut.cityrealtimeweather.ui.selectArea.components.SelectLocalityGridView
import com.lazypeanut.cityrealtimeweather.ui.selectArea.state.SelectAreaScreenState
import com.lazypeanut.cityrealtimeweather.ui.selectArea.state.rememberSelectAreaScreenState

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
                onCityItemTap = { itemIndex ->
                    viewModel.updateTempSelectedCity(itemIndex)
                }
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CurrentSelectedCityItem(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                cityName = uiState.currentSelectedCity?.cityName
            ) {
                selectAreaScreenState.openBottomSheet()
            }
            SelectLocalityGridView(
                localityList = uiState.currentSelectedCity?.cityLocalities
            )
        }
    }
}