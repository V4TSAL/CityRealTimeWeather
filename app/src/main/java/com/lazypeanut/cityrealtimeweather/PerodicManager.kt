package com.lazypeanut.cityrealtimeweather

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.lazypeanut.cityrealtimeweather.network.ApiRepoImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

const val TAG = "PerodicWorker"
@HiltWorker
class PerodicManager @AssistedInject constructor (
    @Assisted val context: Context,
    @Assisted workerParams: WorkerParameters,
    var repo: ApiRepoImpl
) : CoroutineWorker(context,workerParams) {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun doWork(): Result {
        Log.d(TAG, "doWork: ")
        val meow = repo.sendTestNotification()
        val response = repo.getDataByLocalityId()
        var textTitle = "Title _ NONE"
        var textContent = "Content"
        response.onSuccess {
            it.localityWeatherData?.let { wData ->
                textTitle = "${wData.rainIntensity} + ${wData.temperature}"
                wData.rainIntensity?.let { it1 -> textContent = if(it1 > 0){"Its raining in your area"}else{"No rain"} }
            }
        }.onFailure {
            textTitle = "Title _ Went_Wrong"
        }
        val builder = NotificationCompat.Builder(context, "periodicNotification")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(textTitle)
            .setContentText(textContent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val name = "Notification"
        val descriptionText = "text text"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("periodicNotification", name, importance).apply {
            description = descriptionText
        }
        // Register the channel with the system.
        val notificationManager: NotificationManager =
            context.getSystemService(NotificationManager::class.java) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        with(NotificationManagerCompat.from(context)){
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ){
                Log.d(TAG, "doWork: Notification TriggerHit")
                notify( 1,builder.build())
            }
        }
        return Result.success()
    }
}