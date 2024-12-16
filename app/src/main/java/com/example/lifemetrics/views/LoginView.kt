package com.example.lifemetrics.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.actividad.iniciarSesion
import com.example.lifemetrics.conexion.SessionManager
import com.example.navigateprojects.components.MainButtonH
import com.example.navigateprojects.components.PasswordTextField
import com.example.navigateprojects.components.Space
import com.example.navigateprojects.components.TextFields2

//@Composable
//fun Login(navController: NavController) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//
//        Image(
//            painter = painterResource(id = R.drawable.item1),
//            contentDescription = "Imagen1",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(10.dp)
//        ) {
//
//            Image(painter = painterResource(id = R.drawable.logo),
//                contentDescription = "logo",
//                modifier = Modifier
//                    .size(180.dp)
//                    .offset(y = (-40).dp)
//            )
//
//            TextFields(
//                value = "",
//                onValueChange = { /* Lógica del correo */ },
//                label = "Correo"
//            )
//
//            Space()
//
//            TextFields(
//                value = "",
//                onValueChange = { /* Lógica de la contraseña */ },
//                label = "Contraseña",
//                //visualTransformation = PasswordVisualTransformation()
//            )
//
//            Space()
//
//            MainButtonH(
//                name = "Iniciar Sesión",
//                backColor = Color(138,162,212),
//                color = Color.White,
//                size = 15.dp
//            ) {
//                // El merequetengue que hara el boton
//            }
//
//            Space()
//
//            MainButtonH(
//                name = "Registrarte",
//                backColor = Color(138,162,212),
//                color = Color.White,
//                size = 15.dp
//            ) {
//                navController.navigate("register")
//            }
//        }
//    }
//}


@Composable
fun Login(navController: NavController, sessionManager: SessionManager) {
    var email by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

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

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(180.dp)
                    .offset(y = (-40).dp)
            )

            // Campo de texto para el correo
            TextFields2(
                value = email,
                onValueChange = { email = it },
                label = "Correo",
                keyboardType = KeyboardType.Email
            )

            Space()

            PasswordTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = "Contraseña"
            )

            Space()

            // Botón de iniciar sesión
            MainButtonH(
                name = "Iniciar Sesión",
                backColor = Color(138, 162, 212),
                color = Color.White,
                size = 15.dp
            ) {
                if (email.isNotBlank() && contrasena.isNotBlank()) {
                    iniciarSesion(email, contrasena, sessionManager, navController, onError = {
                        errorMessage = it
                    })
                } else {
                    errorMessage = "Por favor completa todos los campos"
                }
            }

            Space()

            // Mostrar mensaje de error si ocurre
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Space()

            // Botón para registrarse
            MainButtonH(
                name = "Registrarse",
                backColor = Color(138, 162, 212),
                color = Color.White,
                size = 15.dp
            ) {
                navController.navigate("register")
            }
        }
    }
}
