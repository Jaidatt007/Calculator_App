package com.example.calculator.units

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.calculator.R
import com.example.calculator.ui.theme.darkColorButtonNumber
import com.example.calculator.ui.theme.lightColorButtonNumber
import com.example.calculator.ui.theme.warmColorButtonNumber
import com.example.calculator.viewmodel.ThemeViewModel

@Composable
fun ThemeDropdownMenu(
    isExpanded : MutableState<Boolean>,
    themeViewModel: ThemeViewModel
){
    Box() {
        Icon(
            painter = painterResource(R.drawable.twotone_color_lens_24),
            contentDescription = "Theme",
            tint = MaterialTheme.colorScheme.primary
        )
        DropdownMenu(
            modifier = Modifier.background(MaterialTheme.colorScheme.tertiary),
            expanded = isExpanded.value,
            offset = DpOffset((-24).dp,(-6).dp),
            onDismissRequest = {
                isExpanded.value = !isExpanded.value
            }
        ) {
            DropdownMenuItem(
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(painter = painterResource(R.drawable.twotone_color_lens_24),
                            contentDescription = "",
                            modifier = Modifier.padding(end = 4.dp),
                            tint = lightColorButtonNumber)
                        Text(
                            text = "Dark Theme",
                            textAlign = TextAlign.Center,
                            color = lightColorButtonNumber)
                    }
                },
                onClick = {
                    themeViewModel.toggleDarkTheme()
                }
            )
            DropdownMenuItem(
                modifier = Modifier,
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(painter = painterResource(R.drawable.twotone_color_lens_24),
                            contentDescription = "",
                            modifier = Modifier.padding(end = 4.dp),
                            tint = warmColorButtonNumber)
                        Text(
                            text = "Warm Theme",
                            textAlign = TextAlign.Center,
                            color = warmColorButtonNumber)
                    }
                },
                onClick = {
                    themeViewModel.toggleCustomTheme()
                }
            )
            DropdownMenuItem(
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(painter = painterResource(R.drawable.twotone_color_lens_24),
                            contentDescription = "",
                            modifier = Modifier.padding(end = 4.dp),
                            tint = darkColorButtonNumber)
                        Text(
                            text = "Light Theme",
                            textAlign = TextAlign.Center,
                            color = darkColorButtonNumber)
                    }
                },
                onClick = {
                    themeViewModel.resetThemes()
                }
            )
        }
    }
}