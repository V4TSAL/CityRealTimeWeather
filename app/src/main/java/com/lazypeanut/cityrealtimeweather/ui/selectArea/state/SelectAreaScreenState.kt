package com.lazypeanut.cityrealtimeweather.ui.selectArea.state

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class SelectAreaScreenState @OptIn(ExperimentalMaterial3Api::class) constructor(
    val selectCityBottomSheetState: SheetState
){
    var showBottomSheet by mutableStateOf(false)
        private set

    fun openBottomSheet(){
        showBottomSheet = true
    }
    fun closeBottomSheet(){
        showBottomSheet = false
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberSelectAreaScreenState(
    selectCityBottomSheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
) : SelectAreaScreenState = remember(selectCityBottomSheetState) {
    SelectAreaScreenState(selectCityBottomSheetState = selectCityBottomSheetState)
}