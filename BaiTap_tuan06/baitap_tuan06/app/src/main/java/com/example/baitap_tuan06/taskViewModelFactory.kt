package com.example.baitap_tuan06

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class taskViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(taskViewModel::class.java)) {
            return taskViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
