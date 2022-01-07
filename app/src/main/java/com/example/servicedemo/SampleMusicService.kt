package com.example.servicedemo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.util.Log

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/7/22.
 */

class SampleMusicService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    init {
        Log.d("MYTAG","Service is running...")
    }

    override fun onBind(intent: Intent?): IBinder? = null
    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.sound)
        mediaPlayer.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()
        return startId

    }
    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }

}