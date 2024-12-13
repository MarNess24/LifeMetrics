package com.example.lifemetrics.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lifemetrics.dataStore.StoreBoarding
import com.example.lifemetrics.viewModels.MainViewBoarding
import com.example.lifemetrics.views.HistorialScreen
import com.example.lifemetrics.views.HomeView
import com.example.lifemetrics.views.Login
import com.example.lifemetrics.views.Registro
import com.example.lifemetrics.views.RegistrosView
import com.example.lifemetrics.views.SplashScreen

@Composable
fun NavManager() {
    val navController= rememberNavController()
    val context= LocalContext.current
    val dataStore= StoreBoarding(context)
    val store=dataStore.getStoreBoarding.collectAsState(initial = false)

    NavHost (
        navController = navController,
        startDestination = if (store.value == true) "home" else "Splash"
    ) {
        composable("onBoarding") {
            MainViewBoarding(navController, dataStore)
        }

        // Pantalla de Inicio (Home)
        composable("home") {
//            HomeView(navController)
            Login(navController)
//            HistorialScreen(navController)
        }

        // Pantalla de Splash
        composable("Splash") {
            SplashScreen(navController, store.value)
        }

        // Pantalla de Login
        composable("login") {
            Login(navController)
        }


        composable("register") {
            Registro(navController)
        }


        composable("historial") {
            HistorialScreen(navController)
        }

    }
}