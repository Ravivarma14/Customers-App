package com.example.customerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customerapp.data.model.Customer
import com.example.customerapp.data.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(private val repository: CustomerRepository): ViewModel() {

    val customers= repository.getAllCustomers().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addCustomer(customer: Customer){
        viewModelScope.launch {
            repository.insertCustomer(customer)
        }
    }
}