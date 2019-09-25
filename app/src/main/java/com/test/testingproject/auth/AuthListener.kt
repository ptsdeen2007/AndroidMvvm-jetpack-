package com.test.testingproject.auth

interface AuthListener {
    fun onStarts()
    fun onSuccess()
    fun onFailiure(message:String)

}