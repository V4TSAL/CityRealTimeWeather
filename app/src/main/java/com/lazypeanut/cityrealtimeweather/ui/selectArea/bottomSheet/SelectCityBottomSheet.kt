package com.lazypeanut.cityrealtimeweather.ui.selectArea.bottomSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lazypeanut.cityrealtimeweather.ui.components.CustomButton
import com.lazypeanut.cityrealtimeweather.ui.components.PreviewContainer
import com.lazypeanut.cityrealtimeweather.ui.selectArea.components.SelectCityListView
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme
import com.lazypeanut.cityrealtimeweather.utils.CityInformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectCityBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    cityList: List<CityInformation>? = null,
    bottomSheetDismissRequest: () -> Unit,
    confirmAreaSelection: () -> Unit,
    onCityItemTap: (index: Int) -> Unit = {}
) {
    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        onDismissRequest = bottomSheetDismissRequest
    ) {
        SelectCityBottomSheetContent(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .padding(horizontal = 20.dp),
            confirmAreaSelection = confirmAreaSelection,
            bottomSheetDismissRequest = bottomSheetDismissRequest,
            cityList = cityList,
            onCityItemTap = onCityItemTap
        )
    }
}


@Composable
fun SelectCityBottomSheetContent(
    modifier: Modifier = Modifier,
    headerFontColor: Color = AppTheme.colors.onSurface,
    cityList: List<CityInformation>? = null,
    confirmAreaSelection: () -> Unit = {},
    bottomSheetDismissRequest: () -> Unit = {},
    onCityItemTap: (index: Int) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomButton(
                buttonText = "Confirm Selection",
                modifier = Modifier.fillMaxWidth()
            ) {
                confirmAreaSelection()
            }
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Select City",
                    color = headerFontColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Icon(
                    imageVector = Icons.Filled.Close,
                    "close icon",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        bottomSheetDismissRequest()
                    }

                )
            }
            SelectCityListView(
                cityList = cityList,
                onTap = onCityItemTap
            )
        }
    }
}


@Preview
@Composable
private fun SelectCityBottomSheetContentPreview() {
    PreviewContainer() {
        SelectCityBottomSheetContent()
    }
}




