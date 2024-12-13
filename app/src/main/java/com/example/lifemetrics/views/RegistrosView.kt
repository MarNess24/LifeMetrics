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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.actividad.eliminarPaciente
import com.example.lifemetrics.actividad.obtenerPacientes
import com.example.lifemetrics.conexion.SessionManager
import com.example.lifemetrics.data.Paciente
import com.example.navigateprojects.components.PersonCard
import com.example.navigateprojects.components.SpaceH
import com.example.navigateprojects.components.TitleBar

@Composable
fun RegistrosView(navController: NavController, sessionManager: SessionManager) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        // Imagen de fondo
        Image (
            painter = painterResource(id = R.drawable.item2),
            contentDescription = "Imagen1",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            // Logo y "Control Diabetes"
            TitleBar (
                name = "Control Diabetes",
                textColor = Color ( 0xFF49688D ),
                backgroundColor = Color ( 0xFFB0C1D9 ),
                image = R.drawable.logo,
                navController,
                sessionManager
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
            Registros(navController, sessionManager)
        }

        // Botón "Agregar"
        FloatingActionButton (
            onClick = { navController.navigate("Pacientes") },
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
fun Registros(navController: NavController, sessionManager: SessionManager) {
    var pacientes by remember { mutableStateOf<List<Paciente>>(emptyList()) }
    var errorMessage by remember { mutableStateOf("") }

    // Llama a la API para obtener los registros
    LaunchedEffect(Unit) {
        val token = sessionManager.getToken()
        if (token != null) {
            obtenerPacientes(
                token = token,
                onSuccess = { pacientes = it },
                onError = { errorMessage = it }
            )
        } else {
            errorMessage = "Sesión no válida. Por favor, inicia sesión de nuevo."
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(375.dp)
    ) {
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        } else if (pacientes.isEmpty()) {
            Text(
                text = "No hay pacientes registrados",
                modifier = Modifier.padding(8.dp),
                color = Color.Gray
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(pacientes) { paciente ->
                    PersonCard(
                        name = paciente.nombre ?: "Sin nombre",
                        navController = navController,
                        id = paciente.id,
                        sessionManager = sessionManager,
                        onEliminar = { id ->
                            eliminarPaciente(
                                token = sessionManager.getToken() ?: "",
                                id = id,
                                onSuccess = {
                                    pacientes = pacientes.filter { it.id != id } // Actualizar la lista local
                                },
                                onError = { mensajeError ->
                                    errorMessage = mensajeError // Mostrar error si ocurre
                                }
                            )
                        }
                    )
                }
            }

        }
    }
}


//@Composable
//fun Registros( navController: NavController) {
//    // Registros del usuario actual
//    val people = listOf ( "Menganito", "María", "Luna", "Mariana", "Scar", "Karla", "Secretaria" )
//
//    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding ( horizontal = 16.dp )
//            .height ( 375.dp )
//    ) {
//        LazyColumn (
//            modifier = Modifier
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy ( 8.dp )
//        ) {
//            items ( people ) { name ->
//                PersonCard ( name = name , navController )
//            }
//        }
//    }
//}