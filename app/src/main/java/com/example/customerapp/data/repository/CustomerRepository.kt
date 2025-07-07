package com.example.customerapp.data.repository

import com.example.customerapp.data.db.CustomerDao
import com.example.customerapp.data.model.Customer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerRepository @Inject constructor(private val dao: CustomerDao) {

    suspend fun insertCustomer(customer: Customer)= dao.insertCustomer(customer)
    fun getAllCustomers() : Flow<List<Customer>> = dao.getAllCustomers()
}