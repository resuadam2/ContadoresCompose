package com.example.contadorescompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { navController.navigate("ContadorSimple") }
        ) {
            Text("Contador Simple")
        }
        Button(
            onClick = { navController.navigate("VariosContadores") }
        ) {
            Text("Varios Contadores")
        }
        Button(
            onClick = { navController.navigate("ContadoresAvanzados") }
        ) {
            Text("Contadores Avanzados")
        }
        Button(
            onClick = { navController.navigate("ContadoresConEstadoAisladoScreen") }
        ) {
            Text("Contadores con estado aislado")
        }

    }
}
