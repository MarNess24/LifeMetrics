package com.example.lifemetrics.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.actividad.obtenerRegistros
import com.example.lifemetrics.data.Registro
import com.example.navigateprojects.components.CardHistorial

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

        Image(
            painter = painterResource(id = R.drawable.item1),
            contentDescription = "Imagen1",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(bottom = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Regresar",
                    tint = Color(0xFF5A5A5A),
                    modifier = Modifier.size(30.dp)
                )
            }


            Text(
                text = "HISTORIAL",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFF5A5A5A)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(text = "Nombre: ${nombre}", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Edad: ${edad}", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Sexo: ${sexo}", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Peso: ${peso}", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
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
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(registros) { Registro ->
                        CardHistorial(
                            fecha = "",
                            Hora = "",
                            glucosa = "",
                            ArterialS = "",//Registro.presionSistolica,
                            ArterialD = "",//Registro.presionDiastolica
                        )
                    }
                }
            }
        }
    }
}