package com.example.edvora

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edvora.Model.Rides
import com.example.edvora.Model.User
import com.example.edvora.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val responseRides: MutableLiveData<Response<List<Rides>>> = MutableLiveData()
    val responseUser: MutableLiveData<Response<User>> = MutableLiveData()

    fun getRides() {
        viewModelScope.launch {
            responseRides.value = repository.getRides()
        }
    }

    fun getUser() {
        viewModelScope.launch {
            responseUser.value = repository.getUser()
        }
    }

}