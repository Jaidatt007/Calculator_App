package com.example.calculator.screens

import android.widget.Toast
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.resources.listOfButtons1
import com.example.calculator.resources.listOfButtons2
import com.example.calculator.resources.listOfButtons3
import com.example.calculator.units.RoundButton
import com.example.calculator.units.ThemeDropdownMenu
import com.example.calculator.viewmodel.CalculatorViewModel
import com.example.calculator.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(
    modifier: Modifier,
    viewModel: ThemeViewModel,
    calculatorViewModel: CalculatorViewModel
){
    Scaffold(
        modifier = modifier,
        topBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End) {

                var isExpanded : MutableState<Boolean> = remember { (mutableStateOf(value = false)) }

                FloatingActionButton(
                    modifier = Modifier.padding(top = 24.dp, end = 4.dp),
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    containerColor = MaterialTheme.colorScheme.background,
                    onClick = {
                        isExpanded.value = !isExpanded.value
                    }
                ) {
                    ThemeDropdownMenu(
                        isExpanded = isExpanded,
                        themeViewModel = viewModel)
                }
            }
        }
    ) {
        val context = LocalContext.current
        val scrollState1 = rememberScrollState()
        val scrollState2 = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize().padding(it)) {
            Column(modifier = Modifier.fillMaxSize()){
                Column(modifier = Modifier.fillMaxSize().weight(1.5f)
                    .padding(12.dp).horizontalScroll(state = scrollState1),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End) {
                    Text(text = calculatorViewModel.equation.value,
                        maxLines = 1, overflow = TextOverflow.Visible,
                        softWrap = false, fontSize = 39.sp)
                }
                Column(modifier = Modifier.fillMaxSize().weight(1.5f)
                    .padding(12.dp).horizontalScroll(state = scrollState2),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End) {
                    Text(text = calculatorViewModel.result.value,
                        maxLines = 1, overflow = TextOverflow.Visible,
                        fontSize = 64.sp)
                }
                Column(modifier = Modifier.fillMaxSize().weight(0.75f)
                    .padding(start = 12.dp, end = 12.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.End) {
                    IconButton(onClick = {
                        calculatorViewModel.buttonClicked("Del")
                    }) {
                        Icon(painter = painterResource(R.drawable.outline_backspace_24),
                            contentDescription = "Delete",
                            tint = MaterialTheme.colorScheme.primary)
                    }
                    HorizontalDivider(modifier = Modifier.padding(start = 2.dp, top = 4.dp ,end = 2.dp),
                        color = MaterialTheme.colorScheme.onTertiary)
                }
                Column(modifier = Modifier.fillMaxSize().padding(8.dp).weight(8f),
                    verticalArrangement = Arrangement.Bottom) {
                    Column {
                        //Row 1
                        Row(modifier = Modifier.fillMaxWidth()) {
                            FloatingActionButton(
                                modifier = Modifier.padding(4.dp)
                                    .aspectRatio(2.15f).weight(2f),
                                onClick = {
                                    calculatorViewModel.buttonClicked(listOfButtons1[0])
                                },
                                containerColor = MaterialTheme.colorScheme.onTertiary,
                                shape = RoundedCornerShape(38),
                                elevation = FloatingActionButtonDefaults.elevation(4.dp)
                            ) {
                                Text(
                                    text = listOfButtons1[0],
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            FloatingActionButton(
                                modifier = Modifier.padding(4.dp)
                                    .aspectRatio(1f).weight(1f),
                                onClick = {
                                    calculatorViewModel.buttonClicked(listOfButtons1[1])
                                },
                                containerColor = MaterialTheme.colorScheme.onTertiary,
                                shape = RoundedCornerShape(100),
                                elevation = FloatingActionButtonDefaults.elevation(4.dp)
                            ) {
                                Text(
                                    text = listOfButtons1[1],
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            FloatingActionButton(
                                modifier = Modifier.padding(4.dp)
                                    .aspectRatio(1f).weight(1f),
                                onClick = {
                                    calculatorViewModel.buttonClicked(listOfButtons1[2])
                                },
                                containerColor = MaterialTheme.colorScheme.onTertiary,
                                shape = RoundedCornerShape(100),
                                elevation = FloatingActionButtonDefaults.elevation(4.dp)
                            ) {
                                Text(
                                    text = listOfButtons1[2],
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                        //Row 2,3,4
                        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                            items(listOfButtons2) {
                                RoundButton(it, onClick = {
                                    calculatorViewModel.buttonClicked(it)
                                })
                            }
                        }
                        //Row 5
                        Row(modifier = Modifier.fillMaxWidth()) {
                            FloatingActionButton(
                                modifier = Modifier.padding(4.dp)
                                    .aspectRatio(1f).weight(1f),
                                onClick = {
                                    calculatorViewModel.buttonClicked(listOfButtons3[0])
                                },
                                containerColor = MaterialTheme.colorScheme.onTertiary,
                                shape = RoundedCornerShape(100),
                                elevation = FloatingActionButtonDefaults.elevation(4.dp)
                            ) {
                                Text(
                                    text = listOfButtons3[0],
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            FloatingActionButton(
                                modifier = Modifier.padding(4.dp)
                                    .aspectRatio(1f).weight(1f),
                                onClick = {
                                    calculatorViewModel.buttonClicked(listOfButtons3[1])
                                },
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(100),
                                elevation = FloatingActionButtonDefaults.elevation(4.dp)
                            ) {
                                Text(
                                    text = listOfButtons3[1],
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            FloatingActionButton(
                                modifier = Modifier.padding(4.dp)
                                    .aspectRatio(2.15f).weight(2f),
                                onClick = {
                                    try {
                                        calculatorViewModel.buttonClicked(listOfButtons3[2])
                                    } catch (e : Exception){
                                        Toast.makeText( context  , "Invalid Operation !" , Toast.LENGTH_SHORT).show()
                                    }

                                },
                                containerColor = MaterialTheme.colorScheme.onTertiary,
                                shape = RoundedCornerShape(38),
                                elevation = FloatingActionButtonDefaults.elevation(4.dp)
                            ) {
                                Text(text = listOfButtons3[2],
                                    fontSize = 36.sp,
                                    color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
        }
    }
}