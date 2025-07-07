package com.example.customerapp.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.customerapp.data.model.Customer
import com.example.customerapp.utils.Validator
import com.example.customerapp.viewmodel.CustomerViewModel

@Composable
fun CustomerForm(viewModel: CustomerViewModel, navController:NavController) {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var city by remember {
        mutableStateOf("")
    }



    // UI
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = firstName, onValueChange = {firstName=it} , label = { Text(text = "First Name")})
        OutlinedTextField(value = lastName, onValueChange = {lastName=it} , label = { Text(text = "Last Name")})
        OutlinedTextField(value = email, onValueChange = {email=it} , label = { Text(text = "Enter Email")})
        OutlinedTextField(value = phone, onValueChange = {phone=it} , label = { Text(text = "Enter Mobile Number")})
        OutlinedTextField(value = city, onValueChange = {city=it} , label = { Text(text = "Enter City Name")})

        val context = LocalContext.current

        Button(onClick = {

            when {
                !Validator.isValidEmail(email) -> {
                    Toast.makeText(context, "Invalid email format", Toast.LENGTH_SHORT).show()
                }
                !Validator.isValidPhone(phone) -> {
                    Toast.makeText(context, "Phone number must be at least 10 digits", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val customer = Customer(0, firstName, lastName, email, phone, city)
                    viewModel.addCustomer(customer)
                    navController.navigate("customerList")
                }
            }

                 /*if(Validator.isValidEmail(email) && Validator.isValidPhone(phone)){
                     val customer = Customer(0,firstName,lastName,email,phone,city)
                     viewModel.addCustomer(customer)
                     navController.navigate("customerList")
                 }
            else{
                Toast.makeText(currentCompositionLocalContext, "not valid",Toast.LENGTH_SHORT).show()
                 }*/
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Submit")
        }
    }


}