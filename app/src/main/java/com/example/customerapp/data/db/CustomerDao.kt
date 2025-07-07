package com.example.customerapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.customerapp.data.model.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("Select * From customer")
    fun getAllCustomers(): Flow<List<Customer>>
}