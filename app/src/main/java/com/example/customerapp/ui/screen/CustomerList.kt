package com.example.customerapp.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.customerapp.data.model.Customer
import com.example.customerapp.utils.Validator
import com.example.customerapp.viewmodel.CustomerViewModel

/*
@Composable
fun CustomerList(viewModel: CustomerViewModel) {

    val customers by viewModel.customers.collectAsState()

    LazyColumn {
        items(customers){
            Text(
                text = "${it.firstName} ${it.lastName} - ${it.email}",
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerList(viewModel: CustomerViewModel) {
    val customers by viewModel.customers.collectAsState()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val showSheet = remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showSheet.value = true },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(customers) { customer ->
                CustomerCard(customer)
            }
        }

        if (showSheet.value) {
            ModalBottomSheet(
                onDismissRequest = { showSheet.value = false },
                sheetState = sheetState
            ) {
                CustomerForm(
                    onSubmit = { customer ->
                        viewModel.addCustomer(customer)
                        showSheet.value = false
                    }
                )
            }
        }
    }
}

@Composable
fun CustomerCard(customer: Customer) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "${customer.firstName} ${customer.lastName}", style = MaterialTheme.typography.titleMedium, color = Color.White)
            Text(text = "Email: ${customer.email}")
            Text(text = "Phone: ${customer.phone}")
            Text(text = "City: ${customer.city}")
        }
    }
}

@Composable
fun CustomerForm(onSubmit: (Customer) -> Unit) {
    val context = LocalContext.current

    var fName by remember { mutableStateOf("") }
    var lName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {

        OutlinedTextField(value = fName, onValueChange = { fName = it }, label = { Text("First Name") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = lName, onValueChange = { lName = it }, label = { Text("Last Name") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = city, onValueChange = { city = it }, label = { Text("City") }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (Validator.isValidEmail(email) && Validator.isValidPhone(phone)) {
                    onSubmit(Customer(0, fName, lName, email, phone, city))
                } else {
                    Toast.makeText(context, "Invalid Email or Phone", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Submit")
        }
    }
}

