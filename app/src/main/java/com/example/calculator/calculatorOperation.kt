package com.example.calculator

sealed class calculatorOperation(val symbol:String){
    object Add:calculatorOperation("+")
    object Subtract:calculatorOperation("-")
    object Multiply:calculatorOperation("x")
    object Divide:calculatorOperation("/")
}
