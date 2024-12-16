package com.example.lifemetrics.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.actividad.obtenerRegistros
import com.example.lifemetrics.data.Registro
import com.example.navigateprojects.components.CardHistorial
import com.example.navigateprojects.components.TitleBarH

@Composable
fun HistorialScreen(navController: NavController, id: String, nombre: String, edad: String, sexo: String, peso: String, altura: String) {
    var registros by remember { mutableStateOf<List<Registro>>(emptyList()) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        obtenerRegistros(
            pacienteId = id,
            onSuccess = { registros = it },
            onError = { errorMessage = it }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.item1),
            contentDescription = "Imagen1",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título en la parte superior
            TitleBarH(
                name = "Historial",
                textColor = Color(0xFF49688D),
                backgroundColor = Color(0xFFB0C1D9),
                image = R.drawable.logo,
                navController = navController
            )

            // Espaciado después del título
            Spacer(modifier = Modifier.height(16.dp))


            Column {
                Text(text = "Nombre: ${nombre}", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Edad: ${edad} años", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Sexo: ${sexo}", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Peso: ${peso} kg", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Altura: ${altura}m", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de registros
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(8.dp)
                )
            } else if (registros.isEmpty()) {
                Text(
                    text = "No hay registros disponibles",
                    color = Color.Gray,
                    modifier = Modifier.padding(8.dp)
                )
            } else {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(registros) { Registro ->
                        CardHistorial(
                            fecha = "Fecha: "+Registro.fecha,
                            Hora =  "Hora: "+Registro.hora,
                            glucosa = "Glucosa: "+Registro.glucosa + " mg/dL",
                            ArterialS = "Presión Arterial Sistólica: " +Registro.presionS + " mmHg",//Registro.presionSistolica,
                            ArterialD = "Presión Arterial Diastólica: "+Registro.presionD +" mmHg"//Registro.presionDiastolica
                        )
                    }
                }
            }
        }
    }
}