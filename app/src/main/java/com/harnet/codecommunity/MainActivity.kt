package com.harnet.codecommunity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harnet.codecommunity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textForTest.text = "Good bye!"
    }
}