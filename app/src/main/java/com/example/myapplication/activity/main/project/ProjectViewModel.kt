package com.example.myapplication.activity.main.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entity.project.ProjectTree
import com.example.myapplication.entity.tree.Tree
import com.example.myapplication.network.BaseResponse
import com.example.myapplication.network.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectViewModel : ViewModel() {
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private val _projectTreesLiveData =MutableLiveData<List<ProjectTree>>()
    val projectTreesLiveData:LiveData<List<ProjectTree>> = _projectTreesLiveData

    fun getProjectTrees(){
        NetworkUtil.wanAndroidApi.getProjectTrees().enqueue(object : Callback<BaseResponse<List<ProjectTree>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<ProjectTree>>>,
                response: Response<BaseResponse<List<ProjectTree>>>
            ) {
                _projectTreesLiveData.value=response.body()?.data
            }

            override fun onFailure(call: Call<BaseResponse<List<ProjectTree>>>, t: Throwable) {
                _errorLiveData.value = t.message
            }

        })
    }
}