package com.example.calculator

data class calculaterState(
    val number1:String = "",
    val number2:String = "",
    val operation: calculatorOperation? = null
)
