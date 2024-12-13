package com.example.lifemetrics.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.navigateprojects.components.MainButton
import com.example.navigateprojects.components.Space
import com.example.navigateprojects.components.TextFields

@Composable
fun Registro(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.item1),
            contentDescription = "Imagen1",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
            
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .offset(y = (-40).dp))
            
        TextFields(
            value = "",
            onValueChange = { /* Lógica del correo */ },
            label = "Correo"
        )

        Space()

        TextFields(
            value = "",
            onValueChange = { /* Lógica de la contraseña */ },
            label = "Contraseña",
            //visualTransformation = PasswordVisualTransformation()
        )

        Space()

        TextFields(
            value = "",
            onValueChange = { /* Lógica para confirmar contraseña */ },
            label = "Confirmar Contraseña",
            //visualTransformation = PasswordVisualTransformation()
        )

        Space()

        MainButton(
            name = "Registrarse",
            backColor = Color(138,162,212),
            color = Color.White,
            size = 15.dp
        ) {
            // Lógica de registro
        }

        Space()

        MainButton(
            name = "Volver a Inicio",
            backColor = Color(138,162,212),
            color = Color.White,
            size = 15.dp
        ) {
            navController.navigate("home")
        }
    }
    }
}