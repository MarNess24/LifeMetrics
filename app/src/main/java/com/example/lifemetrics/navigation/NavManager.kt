package com.example.lifemetrics.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lifemetrics.conexion.SessionManager
import com.example.lifemetrics.dataStore.StoreBoarding
import com.example.lifemetrics.viewModels.MainViewBoarding
import com.example.lifemetrics.views.ControlDiaView
import com.example.lifemetrics.views.DatosPacienteView
import com.example.lifemetrics.views.HistorialScreen
import com.example.lifemetrics.views.HomeView
import com.example.lifemetrics.views.Login
import com.example.lifemetrics.views.RegistrarView
import com.example.lifemetrics.views.RegistrosView
import com.example.lifemetrics.views.SplashScreen

@Composable
fun NavManager() {
    val navController= rememberNavController()
    val context= LocalContext.current
    val dataStore= StoreBoarding(context)
    val store=dataStore.getStoreBoarding.collectAsState(initial = false)

    // Crear instancia de SessionManager
    val sessionManager = remember { SessionManager(context) }

    NavHost (
        navController = navController,
        startDestination = if (store.value == true) "login" else "Splash"
    ) {
        composable("onBoarding") {
            MainViewBoarding(navController, dataStore)
        }

        // Pantalla de Inicio (Home)
        composable("home") {
//            HomeView(navController)
//            Login(navController)
//            HistorialScreen(navController)
            RegistrosView(navController, sessionManager)
        }

        // Pantalla de Splash
        composable("Splash") {
            SplashScreen(navController, store.value)
        }

        // Pantalla de Login
        composable("login") {
            Login(navController, sessionManager)
        }

//        composable("historial") {
//            HistorialScreen(navController)
//        }

        composable("historial/{id}/{nombre}/{edad}/{sexo}/{peso}/{altura}"
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val edad = backStackEntry.arguments?.getString("edad") ?: ""
            val sexo = backStackEntry.arguments?.getString("sexo") ?: ""
            val peso = backStackEntry.arguments?.getString("peso") ?: ""
            val altura = backStackEntry.arguments?.getString("altura") ?: ""
            HistorialScreen(navController, id, nombre, edad, sexo, peso, altura)
        }

        composable("Pacientes") {
            DatosPacienteView(navController, sessionManager)
        }

//        composable("ControlDelDia") {
//            ControlDiaView(navController)
//        }

        composable("ControlDelDia/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            ControlDiaView(navController, id)
        }

        // Pantalla de Login
        composable("register") {
            RegistrarView(navController, sessionManager)
        }



    }
}