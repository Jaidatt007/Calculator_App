package com.example.calculator.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = darkColorBackground,
    surface = darkColorText,
    primary = darkColorButtonNumber,
    secondary = darkColorButtonSymbol,
    tertiary = darkColorButtonBackground,
    onTertiary = darkColorSymbolBackground
)

private val LightColorScheme = lightColorScheme(
    background = lightColorBackground,
    surface = lightColorText,
    primary = lightColorButtonNumber,
    secondary = lightColorButtonSymbol,
    tertiary = lightColorButtonBackground,
    onTertiary = lightColorSymbolBackground
)

private val CustomColorScheme = lightColorScheme(
    background = warmColorBackground,
    surface = warmColorText,
    primary = warmColorButtonNumber,
    secondary = warmColorButtonSymbol,
    tertiary = warmColorButtonBackground,
    onTertiary = warmColorSymbolBackground
)

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    customTheme: Boolean = false,
    lightTheme: Boolean = false,
    useSystemTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        useSystemTheme && isSystemInDarkTheme() -> DarkColorScheme
        useSystemTheme && !isSystemInDarkTheme() -> LightColorScheme
        darkTheme -> DarkColorScheme
        customTheme -> CustomColorScheme
        lightTheme -> LightColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}