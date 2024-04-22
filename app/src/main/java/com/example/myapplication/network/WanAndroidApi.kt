package com.example.myapplication.network

import com.example.myapplication.entity.banner.Banner
import com.example.myapplication.entity.homearticles.HomeArticles
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WanAndroidApi {
    @GET("article/list/{page}/json")
    fun getHomeArticles(@Path("page") page: Int): Call<BaseResponse<HomeArticles>>

    @GET("banner/json")
    fun getBanners():Call<BaseResponse<List<Banner>>>
}