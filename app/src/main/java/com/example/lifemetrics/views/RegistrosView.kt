package com.example.lifemetrics.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lifemetrics.R
import com.example.navigateprojects.components.PersonCard
import com.example.navigateprojects.components.SpaceH
import com.example.navigateprojects.components.TitleBar

@Composable
fun RegistrosView() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        // Imagen de fondo
        Image (
            painter = painterResource ( id = R.drawable.item2 ),
            contentDescription = "Detalle izquierdo",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        )

        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            // Logo y "Control Diabetes"
            TitleBar (
                name = "Control Diabetes",
                textColor = Color ( 0xFF49688D ),
                backgroundColor = Color ( 0xFFB0C1D9 ),
                image = R.drawable.logo
            )

            SpaceH ( 20.dp)

            // Título de los registros "Personas Registradas"
            Text (
                text = "Personas registradas",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color ( 0xFF49688D ),
                modifier = Modifier
                    .padding ( start = 28.dp, top = 16.dp )
            )

            SpaceH ( 20.dp )

            // Usuarios registrados desde la cuenta actual
            Registros()
        }

        // Botón "Agregar"
        FloatingActionButton (
            onClick = { /* Códigou */ },
            containerColor = Color ( 0xFF6481C1 ),
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .size ( 80.dp )
                .align ( Alignment.BottomEnd )
                .offset ( y = -85.dp, x = -40.dp )
        ) {
            Icon (
                imageVector = Icons.Default.Add,
                contentDescription = "Agregar",
                modifier = Modifier.size ( 50.dp )
            )
        }

        // Texto "Agregar"
        Text (
            text = "Agregar",
            fontSize = 20.sp,
            color = Color ( 0xFF49688D ),
            modifier = Modifier
                .align ( Alignment.BottomEnd )
                .padding ( end = 43.dp, bottom = 170.dp )
        )
    }
}

@Composable
fun Registros() {
    // Registros del usuario actual
    val people = listOf ( "Menganito", "María", "Luna", "Mariana", "Scar", "Karla", "Secretaria" )

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding ( horizontal = 16.dp )
            .height ( 375.dp )
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy ( 8.dp )
        ) {
            items ( people ) { name ->
                PersonCard ( name = name )
            }
        }
    }
}