package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.main = this
    }

    fun btnStartService() {
        Intent(this, SampleService::class.java).also {
            startService(it)
            binding.statusTextView.text = "Service Started"
        }
    }

    fun btnStopService() {
        Intent(this, SampleService::class.java).also {
            stopService(it)
            binding.statusTextView.text = "Service Stopped"
        }
    }

    fun btnSendData() {
        Intent(this, SampleService::class.java).also {
            val sampleData = binding.dataEditText.text.toString()
            it.putExtra("Sample_data", sampleData)
            startService(it)
        }
    }
}