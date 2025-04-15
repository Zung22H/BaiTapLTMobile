package com.example.baitap_tuan06

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class taskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskDao = TaskDatabase.getDatabase(application).taskDao()

    // StateFlow để quan sát danh sách task
    private val _tasks = MutableStateFlow<List<taskModel>>(emptyList())
    val tasks: StateFlow<List<taskModel>> = _tasks

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _tasks.value = taskDao.getAllTasks()
        }
    }

    fun addTask(task: taskModel) {
        viewModelScope.launch {
            taskDao.insertTask(task)
            loadTasks()
        }
    }

    fun deleteTask(task: taskModel) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
            loadTasks()
        }
    }

}
