package com.example.calculator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculator.repository.ThemeRepository

class ThemeViewModel : ViewModel() {

    private val _themeRepository : ThemeRepository = ThemeRepository()

    private val _darkTheme = mutableStateOf(_themeRepository.get_darkTheme().state)
    private val _customTheme = mutableStateOf(_themeRepository.get_customTheme().state)
    private val _lightTheme = mutableStateOf(_themeRepository.get_lightTheme().state)
    private val _useSystemTheme = mutableStateOf(_themeRepository.get_useSystemTheme().state)

    val darkTheme : MutableState<Boolean> = _darkTheme
    val customTheme : MutableState<Boolean> = _customTheme
    val lightTheme : MutableState<Boolean> = _lightTheme
    val useSystemTheme : MutableState<Boolean> = _useSystemTheme


    fun toggleDarkTheme() {
        _themeRepository.toggleDarkTheme()
        _darkTheme.value = _themeRepository.get_darkTheme().state
        _customTheme.value = _themeRepository.get_customTheme().state
        _lightTheme.value = _themeRepository.get_lightTheme().state
        _useSystemTheme.value = _themeRepository.get_useSystemTheme().state
    }

    fun toggleCustomTheme() {
        _themeRepository.toggleCustomTheme()
        _darkTheme.value = _themeRepository.get_darkTheme().state
        _customTheme.value = _themeRepository.get_customTheme().state
        _lightTheme.value = _themeRepository.get_lightTheme().state
        _useSystemTheme.value = _themeRepository.get_useSystemTheme().state
    }

    fun resetThemes() {
        _themeRepository.resetThemes()
        _darkTheme.value = _themeRepository.get_darkTheme().state
        _customTheme.value = _themeRepository.get_customTheme().state
        _lightTheme.value = _themeRepository.get_lightTheme().state
        _useSystemTheme.value = _themeRepository.get_useSystemTheme().state
    }
}
