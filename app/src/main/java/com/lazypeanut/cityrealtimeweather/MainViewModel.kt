package com.lazypeanut.cityrealtimeweather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.messaging
import com.lazypeanut.cityrealtimeweather.network.ApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class DeviceInformation(
    val deviceId: String? = null,
    val fcmToken: String? = null,
)
@HiltViewModel
class MainViewModel @Inject constructor(val apiRepo: ApiRepo) : ViewModel() {
    val TAG = "MainViewModel"
    fun getApiData(){
        Log.d(TAG, "getApiData: from main view model")
        viewModelScope.launch {
            apiRepo.getDataByLocalityId()
        }
    }

    fun sendNotification(){
        Log.d(TAG, "getApiData: from main view model")
        viewModelScope.launch {
            apiRepo.sendTestNotification()
        }
    }

    fun getFcmToken(){
        FirebaseInstallations.getInstance().id.addOnCompleteListener {phoneId ->
            if(phoneId.isSuccessful){
                Log.d(TAG, "Firebase device ID is: ${phoneId.result}")
                val id = phoneId.result
                FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                        return@addOnCompleteListener
                    }
                    val token = task.result
                    viewModelScope.launch {
                        apiRepo.sendDeviceInformation(deviceInfo = DeviceInformation(
                            fcmToken = token,
                            deviceId = id
                        ))
                    }
                }
            }

        }
    }
}