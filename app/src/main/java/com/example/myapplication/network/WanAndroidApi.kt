package com.example.myapplication.network

import com.example.myapplication.entity.home.Banner
import com.example.myapplication.entity.home.Friend
import com.example.myapplication.entity.home.HomeArticles
import com.example.myapplication.entity.home.Hotkey
import com.example.myapplication.entity.home.TopArticle
import com.example.myapplication.entity.navi.Navi
import com.example.myapplication.entity.project.ProjectList
import com.example.myapplication.entity.project.ProjectTree
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
    fun getTreeArticles(@Query("cid")cid:Int):Call<BaseResponse<List<TreeArticles>>>

    @GET("article/list/0/json")
    fun getAuthorArticles(@Query("author")author:String):Call<BaseResponse<AuthorArticles>>

    @GET("navi/json")
    fun getNavis():Call<BaseResponse<List<Navi>>>

    @GET("project/tree/json")
    fun getProjectTrees():Call<BaseResponse<List<ProjectTree>>>

    @GET("project/list/1/json")
    fun getProjectList(@Query("cid")cid:Int):Call<BaseResponse<ProjectList>>

}