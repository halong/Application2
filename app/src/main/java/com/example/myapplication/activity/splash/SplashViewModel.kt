package com.example.myapplication.activity.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.database.DatabaseUtil
import com.example.myapplication.entity.home.Banner
import com.example.myapplication.entity.home.HomeArticle
import com.example.myapplication.entity.home.HomeArticles
import com.example.myapplication.entity.tree.AuthorArticles
import com.example.myapplication.network.BaseResponse
import com.example.myapplication.network.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashViewModel(application: Application) : AndroidViewModel(application) {
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private var curPage = 0
    private var homeArticles: MutableList<HomeArticle> = ArrayList()
    private val _homeArticlesLiveData = MutableLiveData<List<HomeArticle>>()
    val homeArticlesLiveData: LiveData<List<HomeArticle>> = _homeArticlesLiveData

    private val _bannersLiveData = MutableLiveData<List<Banner>>()
    val bannersLiveData: LiveData<List<Banner>> = _bannersLiveData

    private val _authorArticlesLiveData = MutableLiveData<AuthorArticles>()
    val authorArticlesLiveData: LiveData<AuthorArticles> = _authorArticlesLiveData

    fun getHomeArticles() {
        curPage = 0
        NetworkUtil.wanAndroidApi.getHomeArticles(curPage)
            .enqueue(object : Callback<BaseResponse<HomeArticles>> {
                override fun onResponse(
                    call: Call<BaseResponse<HomeArticles>>,
                    response: Response<BaseResponse<HomeArticles>>
                ) {
                    homeArticles = (response.body()?.data?.datas as MutableList<HomeArticle>?)!!
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

                    val banner=_bannersLiveData.value?.get(0)
                    if (banner != null) {
                        DatabaseUtil.getInstance(getApplication()).myDatabase.bannerDao().insert(banner)
                    }
                }

                override fun onFailure(call: Call<BaseResponse<List<Banner>>>, t: Throwable) {
                    _errorLiveData.value = t.message
                }

            })
    }

    fun getBannersFromDatabase() {
        _bannersLiveData.value =
            DatabaseUtil.getInstance(getApplication()).myDatabase.bannerDao().banners
    }

    fun getAuthorArticles(){
        NetworkUtil.wanAndroidApi.getAuthorArticles("鸿洋").enqueue(object : Callback<BaseResponse<AuthorArticles>>{
            override fun onResponse(
                call: Call<BaseResponse<AuthorArticles>>,
                response: Response<BaseResponse<AuthorArticles>>
            ) {
                _authorArticlesLiveData.value= response.body()?.data
            }

            override fun onFailure(call: Call<BaseResponse<AuthorArticles>>, t: Throwable) {
                _errorLiveData.value = t.message
            }
        })
    }
}