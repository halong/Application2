package com.example.myapplication.network

data class BaseResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)
