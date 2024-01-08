package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class calculaterViewModel:ViewModel() {
    var state by mutableStateOf(calculaterState())
         

    fun onAction(action: calculatorAction){
        when (action){
            is calculatorAction.Number -> enterNumber(action.number)
            is calculatorAction.Decimal -> enterDecimal()
            is calculatorAction.Clear -> state = calculaterState()
            is calculatorAction.Operation -> enterOperation(action.operation)
            is calculatorAction.Calculate -> performCalculation()
            is calculatorAction.Delete -> performDeletion()

        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()//muda a string para double para fazer o calculo
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null){// é preciso fazer isto por causa do toDoubleOrNull
            val result = when(state.operation) {
                is calculatorOperation.Add -> number1 + number2
                is calculatorOperation.Subtract -> number1 - number2
                is calculatorOperation.Multiply -> number1 * number2
                is calculatorOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),//o resultado no max 15 characters
                number2 = "",
                operation = null
            )
            if (state.number1.length == 8) {
                state = state.copy(
                    number1 = state.number1 + "\n"
                )
            }
        }
    }


    private fun enterOperation(operation: calculatorOperation) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation)//basicamente pega o state e muda apenas a operação sem mudar o state em si
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
                && state.number1.isNotBlank()
        ){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()
        ){
            state = state.copy(
                number1 = state.number2 + "."
            )
            return
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null){
            if (state.number1.length >= MAX_NUMBER_LENGTH){
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.isEmpty()){
            state = state.copy(
                number1 = state.number1 + "\n"
            )
        }
        if (state.number2.length >= MAX_NUMBER_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )

    }

    companion object{
        private const val MAX_NUMBER_LENGTH = 8
    }

}