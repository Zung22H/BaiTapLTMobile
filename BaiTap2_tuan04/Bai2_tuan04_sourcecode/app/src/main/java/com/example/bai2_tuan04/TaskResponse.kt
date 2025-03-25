package com.example.bai2_tuan04

data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task?>,

)

data class TaskResponse2(
    val isSuccess: Boolean,
    val message: String,
    val data: Task

)
