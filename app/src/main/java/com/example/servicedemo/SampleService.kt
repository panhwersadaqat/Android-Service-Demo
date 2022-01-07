package com.example.servicedemo

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/7/22.
 */

class SampleService : Service() {

    init {
        Log.d("MYTAG","Service is running...")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("Sample_data")
        dataString?.let {
            Log.d("MYTAG", dataString)
            for (i in 0..1000){
                Handler().postDelayed({
                    Log.d("MYTAG", i.toString())
                }, 6000)
            }
        }
        return START_STICKY

    }
}