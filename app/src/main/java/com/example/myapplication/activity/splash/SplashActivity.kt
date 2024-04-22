package com.example.myapplication.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.activity.main.MainActivity
import com.example.myapplication.activity.splash.ui.splash.SplashFragment
import com.example.myapplication.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, SplashFragment.newInstance())
//                .commitNow()
//        }


        //startActivity(Intent(this,MainActivity::class.java))

        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        viewModel.errorLiveData.observe(this){
            binding.textView.text = it
        }
        viewModel.bannersLiveData.observe(this){
            binding.textView.text = it.toString()
        }

        var b=true
        binding.textView.setOnClickListener {
            if (b){
                viewModel.getBanners()
                b=false
            }else{
                viewModel.getBannersFromDatabase()
                b=true
            }
        }
    }
}