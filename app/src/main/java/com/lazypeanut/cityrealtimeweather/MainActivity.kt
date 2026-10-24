package com.lazypeanut.cityrealtimeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lazypeanut.cityrealtimeweather.ui.components.BaseScreen
import com.lazypeanut.cityrealtimeweather.ui.screens.selectArea.SelectAreaScreen
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme
import com.lazypeanut.cityrealtimeweather.ui.theme.CityRealTimeWeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeatherSummaryForDeviceId()
        enableEdgeToEdge()
        setContent {
            CityRealTimeWeatherTheme {
                Scaffold(
                    containerColor = AppTheme.colors.surfaceContainerLowest
                ) { innerPadding ->
                    BaseScreen(modifier = Modifier.padding(innerPadding)) {
                        SelectAreaScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "This is the new weather app it uses zomatos API for realtime data $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CityRealTimeWeatherTheme {
        Greeting("Android")
    }
}