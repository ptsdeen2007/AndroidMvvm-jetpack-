package com.test.testingproject.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.testingproject.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {
    fun userLogin(db: String, user: String, password: String): LiveData<String> {
        var logdinRespnse = MutableLiveData<String>()
        MyApi().userLogin(db, user, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    logdinRespnse.value = t.message
                }

                override fun onResponse(call: Call<ResponseBody>,response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        logdinRespnse.value=response.body()?.string()
                    }else{
                        logdinRespnse.value=response.errorBody()?.toString()
                    }
                }
            })
        return  logdinRespnse
    }
}