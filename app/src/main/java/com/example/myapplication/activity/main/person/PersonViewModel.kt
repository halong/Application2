package com.example.myapplication.activity.main.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData:LiveData<String> = _errorLiveData

}