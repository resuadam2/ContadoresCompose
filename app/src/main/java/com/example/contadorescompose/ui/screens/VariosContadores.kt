package com.example.contadorescompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VariosContadoresScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Contadores",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.size(16.dp))
        var countFinal by rememberSaveable { mutableStateOf(0) }
        ContadorMejorado(countFinal) { countFinal += it }
        ContadorMejorado(countFinal) { countFinal += it }
        ContadorTotal(countFinal) { countFinal = 0 }
    }
}

@Composable
fun ContadorTotal(countFinal: Int = 0, modifier: Modifier = Modifier, deleteIncrementoTotal: () -> Unit) {
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

@Composable
fun ContadorMejorado(countFinal: Int, modifier: Modifier = Modifier, incrementoTotal: (Int) -> Unit) {
    var count by rememberSaveable { mutableStateOf(0) }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            FilledTonalButton(onClick = {
                count++
                incrementoTotal(1)
            }) {
                Text(text = "Contador: $count")
            }
            Spacer(Modifier.size(10.dp))
            Text(text = "$count")
            IconButton(onClick = {
                count = 0
            }) {
                Icon(
                    Icons.Outlined.Delete,
                    contentDescription = "Delete button",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorMejoradoPreview() {
    val countFinal = 0
    ContadorMejorado(countFinal) { }
}

@Preview(showBackground = true)
@Composable
fun ContadorTotalPreview() {
    val countFinal = 0
    ContadorTotal(countFinal) { }
}

@Preview(showBackground = true)
@Composable
fun VariosContadoresScreenPreview() {
    VariosContadoresScreen()
}