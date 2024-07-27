package com.example.calculator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculator.repository.CalculatorRepository

class CalculatorViewModel : ViewModel(){

    private val _repository : CalculatorRepository = CalculatorRepository()

    private val _equation = mutableStateOf(_repository.get_inputtedEquation().counterEquation)
    private val _result = mutableStateOf(_repository.get_resultData().resultData)

    val equation : MutableState<String> = _equation
    val result : MutableState<String> = _result

    fun buttonClicked(symbol:String){
        _repository.buttonClicked(symbol = symbol)
        _equation.value = _repository.get_inputtedEquation().counterEquation
        _result.value = _repository.get_resultData().resultData
    }
}