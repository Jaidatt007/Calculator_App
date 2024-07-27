package com.example.calculator.repository

import com.example.calculator.model.themeState

class ThemeRepository {
    private val _darkTheme : themeState = themeState(state = false)
    private val _customTheme : themeState = themeState(state = false)
    private val _lightTheme : themeState = themeState(state = false)
    private val _useSystemTheme : themeState = themeState(state = true)

    fun get_darkTheme() = _darkTheme
    fun get_customTheme() = _customTheme
    fun get_lightTheme() = _lightTheme
    fun get_useSystemTheme() = _useSystemTheme

    fun toggleDarkTheme() {
        _darkTheme.state = true
        _customTheme.state = false
        _lightTheme.state = false
        _useSystemTheme.state = false
    }

    fun toggleCustomTheme() {
        _darkTheme.state = false
        _customTheme.state = true
        _lightTheme.state = false
        _useSystemTheme.state = false
    }

    fun resetThemes() {
        _darkTheme.state = false
        _customTheme.state = false
        _lightTheme.state = true
        _useSystemTheme.state = false
    }
}