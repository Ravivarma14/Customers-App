package com.example.customerapp

import com.example.customerapp.utils.Validator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatorTest {

    @Test
    fun isValidEmail(){
        assertTrue(Validator.isValidEmail("customerOne@ex.com"))
        assertFalse(Validator.isValidEmail("invalidateEmail"))
    }

    @Test
    fun isValidPhone(){
        assertTrue(Validator.isValidPhone("9512354235"))
        assertTrue(Validator.isValidPhone("+918695423560"))
        assertFalse(Validator.isValidPhone("00000"))
    }
}