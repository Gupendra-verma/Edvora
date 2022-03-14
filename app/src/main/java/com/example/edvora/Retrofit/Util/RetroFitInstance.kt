package com.example.edvora.Retrofit.Util

import com.example.edvora.Retrofit.Api.RidesApi
import com.example.edvora.Retrofit.Util.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    val ridesApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RidesApi::class.java)
    }

}