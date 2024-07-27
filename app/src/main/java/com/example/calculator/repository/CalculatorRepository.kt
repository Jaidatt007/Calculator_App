package com.example.calculator.repository

import android.util.Log
import com.example.calculator.model.counterEquation
import com.example.calculator.model.resultData
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorRepository {

    private val _inputtedEquation : counterEquation = counterEquation(counterEquation = "")
    private val _resultData : resultData = resultData(resultData = "0")

    fun get_inputtedEquation() = _inputtedEquation
    fun get_resultData() = _resultData

    fun buttonClicked(symbol:String){
        if(symbol == "AC"){
            _inputtedEquation.counterEquation = ""
            _resultData.resultData = "0"
        }else if(symbol == "Del"){
            _inputtedEquation.counterEquation = _inputtedEquation.counterEquation.dropLast(1)
            _resultData.resultData = "0"
        }else if(symbol == "()"){
            _inputtedEquation.counterEquation = handleParenthesis(_inputtedEquation.counterEquation)
            _resultData.resultData = "0"
        }else if(symbol == "="){
            _resultData.resultData = calculateResult(_inputtedEquation.counterEquation)
            _inputtedEquation.counterEquation = _resultData.resultData
        } else {
            _inputtedEquation.counterEquation += symbol
            _resultData.resultData = "0"
        }
        Log.d("Button Clicked",symbol)
        Log.d("Equation",_inputtedEquation.counterEquation)
        Log.d("Calculating Equation",_inputtedEquation.counterEquation.replace("÷","/").replace("×","*"))
        Log.d("Result",_resultData.resultData)
    }

    fun handleParenthesis(expression: String): String {
        var openParenthesisCount = 0
        var closeParenthesisCount = 0

        // Count the existing parentheses in the current expression
        for (char in expression) {
            when (char) {
                '(' -> openParenthesisCount++
                ')' -> closeParenthesisCount++
            }
        }

        // Determine if we should add an open or close parenthesis
        return when {
            openParenthesisCount > closeParenthesisCount -> {
                if (expression.isNotEmpty() && (expression.last().isDigit() || expression.last() == ')')) {
                    expression + ")"
                } else {
                    expression + "("
                }
            }
            else -> expression + "("
        }
    }
    
    fun calculateResult(equation:String) : String {
        val context : Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable : Scriptable = context.initStandardObjects()
        // variable set to finalResult = jaidattFinalResult
        val jaidattFinalResult = context.evaluateString(scriptable,equation.replace("÷","/").replace("×","*"),"Javascript",1,null).toString()
        Log.d("Final result",jaidattFinalResult)
        if(jaidattFinalResult.startsWith("org")){
            return "0"
        }else{
            if(jaidattFinalResult.endsWith(".0")) {
                return jaidattFinalResult.dropLast(2)
            } else {
                return limitDecimalPlaces(jaidattFinalResult)
            }
        }
    }
    
    fun limitDecimalPlaces(numberString: String, decimalPlaces: Int = 4): String {
        // variable set to number = kaleNumber
        val kaleNumber = numberString.toDoubleOrNull()
        return if (kaleNumber != null) {
            if (kaleNumber == kaleNumber.toInt().toDouble()) {
                kaleNumber.toInt().toString()
            } else {
                String.format("%.${decimalPlaces}f", kaleNumber).trimEnd('0').trimEnd('.')
            }
        } else {
            numberString // Return original string if it's not a valid number
        }
    }
}