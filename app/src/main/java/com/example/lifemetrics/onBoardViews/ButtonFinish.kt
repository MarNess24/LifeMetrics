package com.example.lifemetrics.onBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifemetrics.dataStore.StoreBoarding

@Composable
fun ButtonFinish ( currentPage: Int, navController: NavController, store: StoreBoarding ) {
    Row (
       modifier = Modifier
           .fillMaxWidth()
           .padding(bottom = 10.dp)
           .offset(y = (-100).dp ),
        horizontalArrangement =
            if ( currentPage != 2 ) Arrangement.SpaceBetween
            else Arrangement.Center
    ) {
        if ( currentPage == 2 ) {
            OutlinedButton ( onClick = {
                navController.navigate("home") {
                    popUpTo(0)
                }
            },
                ) {
                Text ( text = "Entrar",
                    color = Color(73,104,141),
                       modifier = Modifier
                           .padding ( horizontal = 40.dp, vertical = 8.dp ),
                    fontWeight = FontWeight.Bold)

            }
        }
    }
}