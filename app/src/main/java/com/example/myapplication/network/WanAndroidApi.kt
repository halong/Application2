package com.example.myapplication.network

import com.example.myapplication.entity.banner.Banner
import com.example.myapplication.entity.friend.Friend
import com.example.myapplication.entity.homearticles.HomeArticles
import com.example.myapplication.entity.hotkey.Hotkey
import com.example.myapplication.entity.toparticles.TopArticle
import com.example.myapplication.entity.tree.AuthorArticles
import com.example.myapplication.entity.tree.Tree
import com.example.myapplication.entity.tree.TreeArticles
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WanAndroidApi {
    @GET("article/list/{page}/json")
    fun getHomeArticles(@Path("page") page: Int): Call<BaseResponse<HomeArticles>>

    @GET("banner/json")
    fun getBanners():Call<BaseResponse<List<Banner>>>

    @GET("friend/json")
    fun getFriends():Call<BaseResponse<List<Friend>>>

    @GET("/hotkey/json")
    fun getHotkeys():Call<BaseResponse<List<Hotkey>>>

    @GET("article/top/json")
    fun getTopArticles():Call<BaseResponse<List<TopArticle>>>

    @GET("tree/json")
    fun getTrees():Call<BaseResponse<List<Tree>>>

    @GET("article/list/0/json")
    fun getTreeArticles(@Query("cid") cid:Int):Call<BaseResponse<List<TreeArticles>>>

    @GET("article/list/0/json")
    fun getAuthorArticles(@Query("author")author:String):Call<BaseResponse<AuthorArticles>>

}