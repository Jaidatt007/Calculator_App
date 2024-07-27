package com.example.calculator.units

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundButton(
    symbol : String,
    onClick : () -> Unit
){
    val containerColor : Color = if(listOf("7","8","9","4","5","6","1","2","3","0").contains(symbol)) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onTertiary
    FloatingActionButton(
        modifier = Modifier.padding(4.dp).aspectRatio(1f),
        onClick = onClick,
        containerColor = containerColor,
        shape = RoundedCornerShape(100),
        elevation = FloatingActionButtonDefaults.elevation(4.dp)
    ) {
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
