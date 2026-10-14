package com.lazypeanut.cityrealtimeweather.network

import com.lazypeanut.cityrealtimeweather.DeviceInformation

interface ApiRepo {
    suspend fun getDataByLocalityId() : Result<ApiResponseModel<LocalityWeatherData>>
    suspend fun sendTestNotification() : Unit
    suspend fun sendDeviceInformation(deviceInfo: DeviceInformation) : Unit
}