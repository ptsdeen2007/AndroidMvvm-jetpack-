package com.test.testingproject.auth

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var companyName: String? = null
    var userName: String? = null
    var password: String? = null
    var authlistener: AuthListener?=null
    fun onLoginButtonClick(v:View){
        Log.d("vw","Clicked")
        authlistener?.onStarts()
        if (companyName.isNullOrEmpty() && userName.isNullOrEmpty() && password.isNullOrEmpty()) {
            authlistener?.onFailiure("Invalid email or password")
            return;
        }
        authlistener?.onSuccess()
    }
}

