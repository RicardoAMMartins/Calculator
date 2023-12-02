package com.example.calculator

sealed class calculatorAction{
    data class Number(val number: Int): calculatorAction()
    object Clear:calculatorAction()
    object Delete:calculatorAction()
    object Decimal:calculatorAction()
    object Calculate:calculatorAction()
    data class Operation(val operation: calculatorOperation):calculatorAction()

}
