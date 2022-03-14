package com.example.edvora

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.edvora.Repository.Repository

class MainViewModelFactory(val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}