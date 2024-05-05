package com.example.myapplication.activity.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entity.home.Banner
import com.example.myapplication.entity.home.HomeArticle
import com.example.myapplication.entity.home.HomeArticles
import com.example.myapplication.network.BaseResponse
import com.example.myapplication.network.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private var curPage = 0
    private val homeArticles: MutableList<HomeArticle> = ArrayList()
    private val _homeArticlesLiveData = MutableLiveData<List<HomeArticle>>()
    val homeArticlesLiveData: LiveData<List<HomeArticle>> = _homeArticlesLiveData

    private val _bannersLiveData = MutableLiveData<List<Banner>>()
    val bannersLiveData: LiveData<List<Banner>> = _bannersLiveData

    fun getHomeArticles() {
        curPage = 0
        NetworkUtil.wanAndroidApi.getHomeArticles(curPage)
            .enqueue(object : Callback<BaseResponse<HomeArticles>> {
                override fun onResponse(
                    call: Call<BaseResponse<HomeArticles>>,
                    response: Response<BaseResponse<HomeArticles>>
                ) {
                    homeArticles.clear()
                    homeArticles.addAll((response.body()?.data?.datas as MutableList<HomeArticle>?)!!)
                    _homeArticlesLiveData.value = homeArticles
                }

                override fun onFailure(call: Call<BaseResponse<HomeArticles>>, t: Throwable) {
                    _errorLiveData.value = t.message
                }
            })
    }

    fun getMoreHomeArticles() {
        curPage++
        NetworkUtil.wanAndroidApi.getHomeArticles(curPage)
            .enqueue(object : Callback<BaseResponse<HomeArticles>> {
                override fun onResponse(
                    call: Call<BaseResponse<HomeArticles>>,
                    response: Response<BaseResponse<HomeArticles>>
                ) {
                    homeArticles.addAll(response.body()?.data?.datas!!)
                    _homeArticlesLiveData.value = homeArticles
                }

                override fun onFailure(call: Call<BaseResponse<HomeArticles>>, t: Throwable) {
                    _errorLiveData.value = t.message
                }
            })
    }

    fun getBanners() {
        NetworkUtil.wanAndroidApi.getBanners()
            .enqueue(object : Callback<BaseResponse<List<Banner>>> {
                override fun onResponse(
                    call: Call<BaseResponse<List<Banner>>>,
                    response: Response<BaseResponse<List<Banner>>>
                ) {
                    _bannersLiveData.value = response.body()?.data
                }

                override fun onFailure(call: Call<BaseResponse<List<Banner>>>, t: Throwable) {
                    _errorLiveData.value = t.message
                }

            })
    }
}