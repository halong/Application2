package com.example.myapplication.entity.home

import com.example.myapplication.entity.home.HomeArticle

data class HomeArticles(
    val curPage: Int,
    val datas: List<HomeArticle>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)