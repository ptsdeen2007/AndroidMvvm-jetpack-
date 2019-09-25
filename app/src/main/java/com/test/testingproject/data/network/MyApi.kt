package com.test.testingproject.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
//    val BASE_URL="https://login.glowsis.com/"
    @FormUrlEncoded
    @POST("erp_login")
    fun userLogin(
        @Field("org") dbName:String,
        @Field("username") userName:String,
        @Field("password") password:String
    ):Call<ResponseBody>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("https://login.glowsis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java);
        }
    }
}