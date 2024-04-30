package com.example.myapplication.activity.main.tree

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entity.tree.Tree
import com.example.myapplication.network.BaseResponse
import com.example.myapplication.network.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TreeViewModel : ViewModel() {
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private val _treesLiveData = MutableLiveData<List<Tree>>()
    val treesLiveData: LiveData<List<Tree>> = _treesLiveData

    fun getTrees(){
        NetworkUtil.wanAndroidApi.getTrees().enqueue(object : Callback<BaseResponse<List<Tree>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<Tree>>>,
                response: Response<BaseResponse<List<Tree>>>
            ) {
                _treesLiveData.value = response.body()?.data
            }

            override fun onFailure(call: Call<BaseResponse<List<Tree>>>, t: Throwable) {
                _errorLiveData.value = t.message
            }

        })
    }

}