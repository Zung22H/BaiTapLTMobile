package com.example.bai2_tuan04

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task?>>()
    val tasks: LiveData<List<Task?>> get() = _tasks

    private val _taskDetail = MutableLiveData<Task?>()
    val taskDetail: LiveData<Task?> get() = _taskDetail

    fun fetchTasks() {
        val apiService = RetrofitClient.instance

        viewModelScope.launch {
            try {
                val response = apiService.getTask() // Gọi API
                if (response.isSuccessful) {
                    _tasks.value = response.body()?.data
                } else {
                    Log.e("TaskViewModel", "Lỗi phản hồi: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("TaskViewModel", "Lỗi kết nối API: ${e.message}")
            }
        }
    }
    fun fetchTaskById(id: String) {
        val apiService = RetrofitClient.instance

        viewModelScope.launch {
            try {
                val response = apiService.getTaskById(id) // Gọi API
                if (response.isSuccessful) {
                    _taskDetail.value = response.body()?.data // Cập nhật giá trị
                } else {
                    Log.e("TaskViewModel", "Lỗi phản hồi: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("TaskViewModel", "Lỗi kết nối API: ${e.message}")
            }
        }}

    }

