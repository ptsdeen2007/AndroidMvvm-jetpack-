package com.test.testingproject.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.test.testingproject.data.repository.UserRepository

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

        var response=UserRepository().userLogin(companyName!!,userName!!,password!!)
        authlistener?.onSuccess(response)

    }
}

