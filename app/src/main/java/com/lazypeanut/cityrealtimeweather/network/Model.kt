package com.lazypeanut.cityrealtimeweather.network

import com.google.gson.annotations.SerializedName

data class ApiResponseModel<T>(
    val status: Int? = null,
    val message: String? = null,
    @SerializedName("device_type")
    val deviceType: Int? = null,
    @SerializedName("locality_weather_data")
    val localityWeatherData: T? = null
)

data class LocalityWeatherData(
    val temperature: Double? = null,
    val humidity: Double? = null,

    @SerializedName("wind_speed")
    val windSpeed: Double? = null,

    @SerializedName("wind_direction")
    val windDirection: Double? = null,

    @SerializedName("rain_intensity")
    val rainIntensity: Double? = null,

    @SerializedName("rain_accumulation")
    val rainAccumulation: Double? = null,

    @SerializedName("aqi_pm_2_point_5")
    val aqiPm2Point5: Int? = null,

    @SerializedName("aqi_pm_10")
    val aqiPm10: Int? = null
)