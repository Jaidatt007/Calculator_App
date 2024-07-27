package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.calculator.screens.CalculatorScreen
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.viewmodel.CalculatorViewModel
import com.example.calculator.viewmodel.ThemeViewModel

class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()
    private val calculatorViewModel : CalculatorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme(
                darkTheme = themeViewModel.darkTheme.value,
                customTheme = themeViewModel.customTheme.value,
                lightTheme = themeViewModel.lightTheme.value,
                useSystemTheme = themeViewModel.useSystemTheme.value) {
                CalculatorScreen(
                    modifier = Modifier.fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    viewModel = themeViewModel,
                    calculatorViewModel = calculatorViewModel
                )
            }
        }
    }
}