package com.example.customerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.customerapp.ui.screen.CustomerForm
import com.example.customerapp.ui.screen.CustomerList
import com.example.customerapp.ui.theme.CustomerAppTheme
import com.example.customerapp.viewmodel.CustomerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CustomerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: CustomerViewModel = hiltViewModel()
                    CustomerList(viewModel = viewModel)
                }
            }


/*
            val navController = rememberNavController()
            val viewModel : CustomerViewModel = hiltViewModel()

            NavHost(navController = navController, startDestination = "form"){
                composable("form"){ CustomerForm(viewModel = viewModel, navController = navController)}
                composable("customerList"){ CustomerList(viewModel = viewModel)}
            }*/
            /*CustomerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomerAppTheme {
        Greeting("Android")
    }
}