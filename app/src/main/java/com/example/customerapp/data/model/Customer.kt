package com.example.customerapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val city: String
)
