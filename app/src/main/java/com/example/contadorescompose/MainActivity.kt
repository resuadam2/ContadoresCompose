package com.example.contadorescompose

import android.accessibilityservice.AccessibilityService.SoftKeyboardController
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.contadorescompose.ui.theme.ContadoresComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadoresComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "Contadores", style = MaterialTheme.typography.displayLarge)
                        var countFinal by rememberSaveable { mutableStateOf(0) }
                        Contador(countFinal) { countFinal += it }
                        Contador(countFinal) { countFinal += it }
                        ContadorFinal(countFinal) { countFinal = 0 }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Contador(countFinal: Int, incrementoTotal: (Int) -> Unit) {
    var count by rememberSaveable { mutableStateOf(0) }
    var increment by rememberSaveable { mutableStateOf("1") }
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
                        context, "El incremento debe ser un número positivo",
                        Toast.LENGTH_SHORT).show()
                } else {
                    count += increment.toInt()
                    incrementoTotal(increment.toInt())
                }
                focusManager.clearFocus() // Hide the keyboard
            }) {
                Text(text = "Contador: $count")
            }
            Spacer(Modifier.size(10.dp))
            Text(text = "$count")
            IconButton(onClick = {
                count = 0
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
                    increment = it
                },
                modifier = Modifier.onFocusChanged {
                    if(it.hasFocus) increment = ""
                    else if (increment.isEmpty()) increment = "1"
                }.width(120.dp),
                label = { Text(text = "Incremento") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
    }
}

@Composable
fun ContadorFinal( countFinal: Int = 0, deleteIncrementoTotal: () -> Unit) {
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