package com.lazypeanut.cityrealtimeweather

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.lazypeanut.cityrealtimeweather.ui.components.BaseScreen
import com.lazypeanut.cityrealtimeweather.ui.selectArea.SelectCityListView
import com.lazypeanut.cityrealtimeweather.ui.selectArea.components.SelectAreaItem
import com.lazypeanut.cityrealtimeweather.ui.theme.CityRealTimeWeatherTheme
import com.lazypeanut.cityrealtimeweather.utils.supportedAreasMap
import com.lazypeanut.cityrealtimeweather.utils.supportedCityList
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CityRealTimeWeatherTheme {
                Scaffold { innerPadding ->
                    BaseScreen(modifier = Modifier.padding(innerPadding)) {
                        SelectCityListView(
                            cityList = supportedCityList
                        )
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