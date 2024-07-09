package com.example.walpapperapi

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WalpapperInterface {


    @GET("api/")
    fun searchImageAPI(
        @Query("key") key:String, @Query("q") q:String, @Query("image_type") image_type:String

    ):retrofit2.Call<ImageModel>

}