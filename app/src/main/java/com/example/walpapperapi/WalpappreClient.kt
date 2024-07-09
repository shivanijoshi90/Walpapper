package com.example.walpapperapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WalpappreClient {


    companion object {
        val BASE_URL = "https://pixabay.com/"

        var retrofit: Retrofit? = null
        fun getClient(): Retrofit? {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }
}