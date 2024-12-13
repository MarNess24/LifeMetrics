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
import com.example.lifemetrics.components.BotonOutline
import com.example.navigateprojects.components.MainButton
import com.example.navigateprojects.components.Space
import com.example.navigateprojects.components.TextFields

@Composable
fun Login(navController: NavController) {
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
            .padding(10.dp)
    ) {

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(180.dp)
                .offset(y = (-40).dp)
            )

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

        MainButton(
            name = "Iniciar Sesión",
            backColor = Color(138,162,212),
            color = Color.White,
            size = 15.dp
        ) {
            // El merequetengue que hara el boton
        }

        Space()

        MainButton(
            name = "Registrarte",
            backColor = Color(138,162,212),
            color = Color.White,
            size = 15.dp
        ) {
            navController.navigate("register") // Navega a la pantalla de registro
        }
    }
    }
}