package com.example.contadorescompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contadorescompose.ui.screens.ContadoresAvanzadosScreen
import com.example.contadorescompose.ui.screens.ContadoresConEstadoAisladoScreen
import com.example.contadorescompose.ui.screens.MainScreen
import com.example.contadorescompose.ui.screens.ScreenContadorSimple
import com.example.contadorescompose.ui.screens.VariosContadoresScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.MainScreen.name) {
        composable(AppScreens.MainScreen.name) {
            MainScreen(navController)
        }
        composable(AppScreens.ContadorSimple.name) {
            ScreenContadorSimple()
        }
        composable(AppScreens.ContadoresAvanzados.name) {
            ContadoresAvanzadosScreen()
        }
        composable(AppScreens.VariosContadores.name) {
            VariosContadoresScreen()
        }
        composable(AppScreens.ContadoresConEstadoAisladoScreen.name) {
            ContadoresConEstadoAisladoScreen()
        }
    }
}