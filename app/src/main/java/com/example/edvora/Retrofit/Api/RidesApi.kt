package com.example.edvora.Retrofit.Api

import com.example.edvora.Model.Rides
import com.example.edvora.Model.User
import retrofit2.Response
import retrofit2.http.GET

interface RidesApi {

    @GET("/rides")
    suspend fun getRides(): Response<List<Rides>>


    @GET("/user")
    suspend fun getUser(): Response<User>

}