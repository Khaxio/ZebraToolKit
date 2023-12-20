package com.example.zebratoolkit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class IOTDataViewModel : ViewModel() {

    private val _serverUri = MutableLiveData<String>()
    val serverUri: LiveData<String> = _serverUri

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    private val _mgmtCommands = MutableLiveData<String>()
    val mgmtCommands: LiveData<String> = _mgmtCommands


    fun onServerUriChanged(serverUri: String) {
        _serverUri.value = serverUri
    }

    fun onMgmtCommandsChanged(mgmtCommands: String) {
        _mgmtCommands.value = mgmtCommands
    }


}