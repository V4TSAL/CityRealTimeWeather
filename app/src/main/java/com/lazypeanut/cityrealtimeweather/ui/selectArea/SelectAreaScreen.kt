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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lazypeanut.cityrealtimeweather.ui.components.BaseScreen
import com.lazypeanut.cityrealtimeweather.ui.components.CustomSearchBar
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
    BaseScreen(modifier = modifier) {
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
            Column{
            Text("Area Selection", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            Text("Choose the areas which you would like to track for weather alerts.", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Normal)
            }
            CustomSearchBar(
                modifier = Modifier.fillMaxWidth(),
                searchValue = uiState.localitySearchValue
            ) { newValue ->
                viewModel.searchLocality(newValue)
            }
            SelectLocalityGridView(
                localityList = uiState.searchLocalityList,
                onTap = {index ->
                    viewModel.selectLocality(index)
                }
            )
        }
    }
}