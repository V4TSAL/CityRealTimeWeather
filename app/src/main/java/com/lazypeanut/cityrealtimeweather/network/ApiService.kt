package com.lazypeanut.cityrealtimeweather.network

import com.lazypeanut.cityrealtimeweather.DeviceInformation
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService{
    @GET("weather/locality")
    suspend fun getDataByLocalityId(@Query("localityId") localityId: String):  ApiResponseModel<LocalityWeatherData>

    @GET("notifications/send-test")
    suspend fun sendTestNotification(): Unit

    @POST("device/info")
    suspend fun sendDeviceInfo(@Body deviceInfo: DeviceInformation): Unit


}