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
    val aqiPm2Point5: Double? = null,

    @SerializedName("aqi_pm_10")
    val aqiPm10: Double? = null
)

data class WeatherSummaryResponse(
    val status: Int? = null,
    val message: String? = null,

    @SerializedName("selected_areas")
    val selectedAreas: List<AreaWeather>? = null,

    @SerializedName("hottest_area")
    val hottestArea: AreaWeather? = null,

    @SerializedName("windiest_area")
    val windiestArea: AreaWeather? = null,

    @SerializedName("most_humid_area")
    val mostHumidArea: AreaWeather? = null,

    @SerializedName("rainiest_area")
    val rainiestArea: AreaWeather? = null,

    @SerializedName("best_aqi_area")
    val bestAqiArea: AreaWeather? = null
)

data class AreaWeather(
    @SerializedName("locality_id")
    val localityId: String? = null,

    @SerializedName("locality_name")
    val localityName: String? = null,

    @SerializedName("weather_condition")
    val weatherCondition: String? = null,

    @SerializedName("weather_data")
    val weatherData: LocalityWeatherData? = null
)
