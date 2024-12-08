package com.example.lifemetrics.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lifemetrics.R
import com.example.navigateprojects.components.ActionButton
import com.example.navigateprojects.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegistrosView() {
    /*Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

    }*/
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    //.statusBarsPadding()
                    .height(150.dp),
                title = {
                    Image(
                            painter = painterResource(id = R.drawable.logo), // Cambia "logo" por el nombre de tu recurso de imagen.
                            contentDescription = "Logo",
                            modifier = Modifier.width(100.dp) // Ajusta el tamaño del logo.
                        )
                    Spacer(modifier = Modifier.width(20.dp)) // Espacio entre el logo y el texto.
                    TitleBar(name = "Control Diabetes")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors (
                    containerColor = Color ( 0xFF6481C1 )
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentRegistrosView()
    }
}

@Composable
fun ContentRegistrosView() {
    /**/
}
