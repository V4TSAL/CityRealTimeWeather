package com.lazypeanut.cityrealtimeweather.ui.selectArea

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.lazypeanut.cityrealtimeweather.ui.components.BaseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectAreaScreen(
    modifier: Modifier = Modifier,
    viewModel: SelectAreaViewModel = hiltViewModel()
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    BaseScreen(modifier = Modifier) {
        if (showBottomSheet) {
            SelectCityBottomSheet(
                bottomSheetDismissRequest = {
                    showBottomSheet = false
                },
                confirmAreaSelection = {
                    showBottomSheet = false
                }
            )
        }
        Column {
            Box(modifier = Modifier.clickable {
                showBottomSheet = true
            }) {
                Text("Hello")
            }
        }
    }
}