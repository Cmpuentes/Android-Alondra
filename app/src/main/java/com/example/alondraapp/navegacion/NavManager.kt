package com.example.alondraapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alondraapp.vistas.VistaDeInicio
import com.example.alondraapp.vistas.VistaDeProductos

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            VistaDeInicio(navController)
        }
        composable("Detail"){
            VistaDeProductos(navController)
        }
    }
}