package com.test.testingproject.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarts()
    fun onSuccess(response: LiveData<String>)
    fun onFailiure(message:String)

}