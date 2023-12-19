package com.example.zebratoolkit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IOTDataViewModel: ViewModel() {

    private val _serverUri = MutableLiveData<String>()
    val serverUri : LiveData<String> = _serverUri
}