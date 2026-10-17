package com.lazypeanut.cityrealtimeweather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    buttonText: String? = null,
    buttonTextColor: Color = AppTheme.colors.borderSubtle,
    defaultButtonColor: Color = AppTheme.colors.borderActive,
    buttonShape: Shape = RoundedCornerShape(12.dp),
    onTap: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(shape = buttonShape)
            .background(defaultButtonColor)
            .clickable {
                onTap()
            },
        contentAlignment = Alignment.Center
    ) {
        buttonText?.let {
            Text(
                it,
                modifier = Modifier.padding(12.dp),
                color = buttonTextColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    PreviewContainer {
        CustomButton(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            buttonText = "Confirm",
            onTap = {})
    }

}