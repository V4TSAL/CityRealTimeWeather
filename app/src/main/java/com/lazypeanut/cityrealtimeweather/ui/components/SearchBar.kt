package com.lazypeanut.cityrealtimeweather.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun customTextFieldColors() = TextFieldDefaults.colors(
    focusedTextColor = Color.White,
    errorContainerColor = AppTheme.colors.surfaceContainer,
    focusedContainerColor = AppTheme.colors.surfaceContainer,
    unfocusedTextColor = Color.White,
    unfocusedContainerColor = AppTheme.colors.surfaceContainer,
    disabledContainerColor = AppTheme.colors.surfaceContainer,
    errorIndicatorColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    errorPlaceholderColor = AppTheme.colors.onSurfaceMuted,
    disabledPlaceholderColor = AppTheme.colors.onSurfaceMuted,
    focusedPlaceholderColor = AppTheme.colors.onSurfaceMuted,
    unfocusedPlaceholderColor = AppTheme.colors.onSurfaceMuted
)

@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    searchValue:String = "",
    placeHolderValue: String = "Search locality",
    onValueChange: (String) -> Unit
) {
    CustomContainer(modifier = modifier, borderColor = Color.Transparent) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchValue,
            onValueChange = onValueChange,
            colors = customTextFieldColors(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, tint = AppTheme.colors.onSurfaceMuted, contentDescription = "Search icon")
            },
            placeholder = {
                Text(text = placeHolderValue)
            }
        )
    }
}

@Preview
@Composable
private fun CustomSearchBarPreview() {
    PreviewContainer() {
        CustomSearchBar(
            modifier = Modifier.padding(12.dp),
            searchValue = ""
        ){}
    }
}