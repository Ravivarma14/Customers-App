package com.example.customerapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.customerapp.data.model.Customer

@Database(entities = [Customer::class], version = 1)
abstract class CustomerDB: RoomDatabase() {
    abstract fun customerDao() : CustomerDao
}