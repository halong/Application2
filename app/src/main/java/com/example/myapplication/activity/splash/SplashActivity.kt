package com.example.myapplication.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.activity.main.MainActivity
import com.example.myapplication.activity.splash.ui.splash.SplashFragment
import com.example.myapplication.databinding.ActivitySplashBinding
import com.example.myapplication.entity.home.Hotkey
import com.example.myapplication.network.BaseResponse
import com.example.myapplication.network.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLEncoder

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SplashActivity"
    }

    private lateinit var binding: ActivitySplashBinding
    //private lateinit var viewModel: SplashViewModel
    private val viewModel:SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e(Companion.TAG, "onCreate: hello")

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, SplashFragment.newInstance())
//                .commitNow()
//        }

        //viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        startActivity(Intent(this,MainActivity::class.java))

//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        binding.recyclerView.layoutManager= layoutManager
//        val strings = ArrayList<String>()
//        strings.add("aaaaaaaaaaaaa")
//        strings.add("aaaaaaaaaaaaa")
//        strings.add("aaaaaaaaaaaaa")
//        strings.add("aaaaaaaaaaaaa")
//        binding.recyclerView.adapter = MyAdapter(strings)
    }


}