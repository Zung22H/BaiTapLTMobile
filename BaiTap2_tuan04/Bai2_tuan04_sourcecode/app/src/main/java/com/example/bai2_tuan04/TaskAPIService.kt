package com.example.bai2_tuan04

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TaskAPIService {
    @GET("task/{id}")
    fun getTaskById(@Path("id") id: String): Response<TaskResponse2>

    @GET("tasks")
    suspend fun getTask(): Response<TaskResponse>
}
