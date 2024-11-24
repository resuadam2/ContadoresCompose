package com.example.contadorescompose.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.contadorescompose.R
import com.example.contadorescompose.ui.state.ContadoresEstadoAisladoViewModel

@Composable
fun ContadoresConEstadoAisladoScreen(vm: ContadoresEstadoAisladoViewModel = ContadoresEstadoAisladoViewModel()) {
    ContadoresEstadoAisladoContent(vm)
}

@Composable
fun ContadoresEstadoAisladoContent(vm: ContadoresEstadoAisladoViewModel) {
    val state by vm.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Contadores avanzados",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.size(16.dp))
        ContadorEstadoAislado(
            count = state.countA,
            increment = state.incrementA,
            changeIncrement = { vm.changeIncrementA(it) },
            incrementCounter = { vm.incrementCountA() },
            resetCounter = { vm.resetCountA() },
            incrementoTotal = { vm.incrementCountFinal(it) }
        )
        Spacer(Modifier.size(16.dp))
        ContadorEstadoAislado(
            count = state.countB,
            increment = state.incrementB,
            changeIncrement = { vm.changeIncrementB(it) },
            incrementCounter = { vm.incrementCountB() },
            resetCounter = { vm.resetCountB() },
            incrementoTotal = { vm.incrementCountFinal(it) }
        )
        ContadorFinalEstadoAislado(
            countFinal = state.countFinal
        ) { vm.resetCountFinal() }
    }
}


@Composable
fun ContadorEstadoAislado(
    count: Int,
    increment: String,
    changeIncrement: (String) -> Unit,
    incrementCounter: () -> Unit,
    resetCounter: () -> Unit,
    incrementoTotal: (Int) -> Unit
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            FilledTonalButton(onClick = {
                if (increment.isEmpty() || increment.toInt() <= 0) {
                    Toast.makeText(
                        context, context.getString(R.string.increment_positive_toast_text),
                        Toast.LENGTH_SHORT).show()
                } else {
                    incrementCounter()
                    incrementoTotal(increment.toInt())
                }
                focusManager.clearFocus() // Hide the keyboard
            }) {
                Text(text = "Contador: $count")
            }
            Spacer(Modifier.size(10.dp))
            Text(text = "$count")
            IconButton(onClick = {
                resetCounter()
                focusManager.clearFocus() // Hide the keyboard
            }) {
                Icon(
                    Icons.Outlined.Delete,
                    contentDescription = "Delete button",
                )
            }
        }
        Row {
            OutlinedTextField(
                value = increment,
                onValueChange = {
                    changeIncrement(it)
                },
                modifier = Modifier
                    .onFocusChanged {
                        if (it.hasFocus) changeIncrement("")
                        else if (increment.isEmpty()) changeIncrement("1")
                    }
                    .width(120.dp),
                label = { Text(text = "Incremento") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
    }
}

@Composable
fun ContadorFinalEstadoAislado(countFinal: Int, resetCountFinal: () -> Unit) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        Text(text = "Contador final: $countFinal")
        IconButton(onClick = resetCountFinal) {
            Icon(
                Icons.Default.Delete,
                contentDescription = "Delete button",
            )
        }
    }
}