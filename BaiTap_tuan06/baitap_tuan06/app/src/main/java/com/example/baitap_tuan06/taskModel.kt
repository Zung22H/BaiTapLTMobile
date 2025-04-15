package com.example.baitap_tuan06

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class taskModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String
)

