package com.example.myapplication.entity.homearticles

data class HomeArticles(
    val curPage: Int,
    val datas: List<HomeArticle>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)