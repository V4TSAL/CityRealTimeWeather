package com.lazypeanut.cityrealtimeweather.network

import android.util.Log
import com.lazypeanut.cityrealtimeweather.DeviceInformation
import retrofit2.HttpException
import javax.inject.Inject

class ApiRepoImpl @Inject constructor(
    private val apiService: ApiService
) : ApiRepo {
    val TAG = "ApiRepoImpl"
    override suspend fun getDataByLocalityId(): Result<ApiResponseModel<LocalityWeatherData>> {
        return try {
            Log.d(TAG, "getDataByLocalityId: onsuccess")
            Result.success(apiService.getDataByLocalityId("ZWL001196"))
        }catch (e : Exception){
            Log.d(TAG, "getDataByLocalityId: onException")
            Result.failure(e)
        }catch (e : HttpException){
            Log.d(TAG, "getDataByLocalityId: onHttpException")
            Result.failure(e)
        }
    }

    override suspend fun sendTestNotification(): Unit{
//        apiService.sendTestNotification()
    }

    override suspend fun sendDeviceInformation(deviceInfo: DeviceInformation) {
        apiService.sendDeviceInfo(deviceInfo = deviceInfo)
    }
}