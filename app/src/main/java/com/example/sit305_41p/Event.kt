package com.example.sit305_41p

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events_table")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val category: String,
    val location: String,
    val date: String,
    val timestamp: Long
)