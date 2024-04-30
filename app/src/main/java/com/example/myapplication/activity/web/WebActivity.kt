package com.example.myapplication.activity.web

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent.getStringExtra()

    }
}