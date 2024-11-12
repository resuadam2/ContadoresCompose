package com.example.contadorescompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.contadorescompose.ui.screens.ContadoresAvanzadosScreen
import com.example.contadorescompose.ui.screens.ScreenContadorSimple
import com.example.contadorescompose.ui.screens.VariosContadoresScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route) {
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }
        composable(AppScreens.ContadorSimple.route) {
            ScreenContadorSimple()
        }
        composable(AppScreens.ContadoresAvanzados.route) {
            ContadoresAvanzadosScreen()
        }
        composable(AppScreens.VariosContadores.route) {
            VariosContadoresScreen()
        }
    }
}