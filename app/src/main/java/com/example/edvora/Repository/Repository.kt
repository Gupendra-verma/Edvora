package com.example.edvora.Repository

import com.example.edvora.Model.Rides
import com.example.edvora.Model.User
import com.example.edvora.Retrofit.Util.RetroFitInstance
import retrofit2.Response

class Repository{

    suspend fun getRides():Response<List<Rides>>{
        return RetroFitInstance.ridesApi.getRides()
    }

    suspend fun getUser():Response<User>{
        return RetroFitInstance.ridesApi.getUser()
    }
}