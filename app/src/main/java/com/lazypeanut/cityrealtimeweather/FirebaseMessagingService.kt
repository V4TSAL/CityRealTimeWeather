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
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@AndroidEntryPoint
class FirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    @ApplicationContext
    lateinit var context: Context

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if(message.data.isNotEmpty()){
            Log.d("FCM_DATA", "Message data payload: ${message.data}")
            val convertedMessage = message.data["message"]
            val builder = NotificationCompat.Builder(context, "periodicNotification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Weather near you")
                .setContentText("${convertedMessage}")
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
        }
    }
}