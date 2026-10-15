package com.lazypeanut.cityrealtimeweather

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.lazypeanut.cityrealtimeweather.ui.selectArea.components.SelectAreaItem
import com.lazypeanut.cityrealtimeweather.ui.theme.AppTheme
import com.lazypeanut.cityrealtimeweather.ui.theme.CityRealTimeWeatherTheme
import com.lazypeanut.cityrealtimeweather.utils.s
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        itemsIndexed(s.keys.toList(), key = { index, item ->
                            "$index+${item.length}"
                        }) { index, item ->
                            SelectAreaItem(cityName = item, numberOfStations = "${s[item]?.size}")
                            Spacer(modifier = Modifier.padding(top = 4.dp))
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                val a = s[item].orEmpty()
                                itemsIndexed(
                                    a,
                                    key = { index, item -> "$index+${item.localityName}" }) { index, item ->
                                    SelectAreaItem(cityName = item.localityName)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun setUpWorker(context: Context) {
        val request = PeriodicWorkRequestBuilder<PerodicManager>(15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "my_unique_periodic_work_name",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
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