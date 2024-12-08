package com.example.lifemetrics.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lifemetrics.dataStore.StoreBoarding
import com.example.lifemetrics.viewModels.MainViewBoarding
import com.example.lifemetrics.views.HomeView
import com.example.lifemetrics.views.RegistrosView

@Composable
fun NavManager() {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getStoreBoarding.collectAsState(initial = false)

    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = if (store.value == true) "home" else "onBoarding"
    ) {
        composable ( "onBoarding" ) {
            MainViewBoarding ( navController, dataStore )
        }

        composable ( "home" ) {
            HomeView ( navController )
        }

        composable ( "registros" ) {
            //RegistrosView ( navController )
        }
    }
}