package com.example.baitap_tuan06

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<taskModel>

    @Insert
    suspend fun insertTask(task: taskModel)

    @Delete
    suspend fun deleteTask(task: taskModel)
}

