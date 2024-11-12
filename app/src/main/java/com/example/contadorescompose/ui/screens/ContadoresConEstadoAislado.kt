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
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Contadores avanzados",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.size(16.dp))
        ContadorEstadoAislado (
            vm,
            vm.state.countA,
            vm.state.incrementA,
            vm.state.countFinal
        )
        { vm.incrementCountFinal(it) }
        ContadorEstadoAislado(vm.state.countFinal) { vm.incrementCountFinal(it) }
        ContadorFinal(vm.state.countFinal) { vm.resetCountFinal() }
    }
}


@Composable
fun ContadorEstadoAislado(
    vm: ContadoresEstadoAisladoViewModel,
    count: Int,
    increment: String,
    incrementoTotal: (Int) -> Unit) {
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
                    /* TODO */
                    incrementoTotal(increment.toInt())
                }
                focusManager.clearFocus() // Hide the keyboard
            }) {
                Text(text = "Contador: $count")
            }
            Spacer(Modifier.size(10.dp))
            Text(text = "$count")
            IconButton(onClick = {
                /* TODO */
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
                    /* TODO */
                },
                modifier = Modifier
                    .onFocusChanged {
                        if (it.hasFocus) vm.modifyIncrementA("")
                        else if (increment.isEmpty()) vm.modifyIncrementA("1")
                    }
                    .width(120.dp),
                label = { Text(text = "Incremento") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
    }
}

@Composable
fun ContadorFinalEstadoAislado(countFinal: Int = 0, deleteIncrementoTotal: () -> Unit) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        Text(text = "Contador final: $countFinal")
        IconButton(onClick = { deleteIncrementoTotal() }) {
            Icon(
                Icons.Default.Delete,
                contentDescription = "Delete button",
            )
        }
    }
}