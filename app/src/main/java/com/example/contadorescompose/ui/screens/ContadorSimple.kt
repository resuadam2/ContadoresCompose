package com.example.contadorescompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenContadorSimple(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ContadorSimple()
    }
}

@Composable
fun ContadorSimple(modifier: Modifier = Modifier) {
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
fun ContadorSimplePreview() {
    ContadorSimple()
}