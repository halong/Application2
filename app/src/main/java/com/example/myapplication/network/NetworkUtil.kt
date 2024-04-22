package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtil {
    private const val BASEURL = "https://www.wanandroid.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val wanAndroidApi: WanAndroidApi = retrofit.create(WanAndroidApi::class.java)
}