package com.example.customerapp.utils

import android.util.Patterns

object Validator {
    fun isValidEmail(email:String)= Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isValidPhone(phone:String)= phone.length>=10 && phone.length<=13 && phone.all { it.isDigit() }
}