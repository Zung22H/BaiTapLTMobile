package com.example.baitap_tuan06

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class taskViewModel : ViewModel() {

    private val _tasks = mutableStateListOf<taskModel>()
    val tasks: List<taskModel> get() = _tasks

    fun addTask(task: taskModel) {
        _tasks.add(task)
    }
}
