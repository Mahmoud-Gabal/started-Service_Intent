package com.example.servicesintent

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Process.THREAD_PRIORITY_BACKGROUND
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread


class HelloService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread {
            while (true) {
                Thread.sleep(2000)
                Log.d("fromServiceOne","hello from service")
            }
        }
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
//        start()
        return super.onStartCommand(intent, flags, startId)
    }

//    private fun start() {
//        val notification = NotificationCompat.Builder(this, "channelOne")
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setContentTitle("serviceOne")
//            .setContentText("hello from service one")
//            .setContentInfo("this is content info")
//            .build()
//        startForeground(1, notification)
//    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "service stopped", Toast.LENGTH_SHORT).show()
    }
}