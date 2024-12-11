package com.example.lifemetrics.viewModels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.navigateprojects.components.CardHistorial

@Composable
fun HistorialScreen(navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Fondo gris claro
    ) {
        // Flecha de regreso
        Box(
            modifier = Modifier
                .padding(16.dp)
                .clickable { navController.popBackStack() }
        ) {
            Image(painter = painterResource(id = R.drawable.item2), contentDescription = "Imagen2")
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Regresar",
                tint = Color(0xFF5A5A5A),
                modifier = Modifier.size(24.dp)
            )
        }

        // Encabezado
        Text(
            text = "HISTORIAL",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center,
            color = Color(0xFF5A5A5A)
        )

        // Datos personales
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Nombre: María", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
            Text(text = "Edad: 65", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
            Text(text = "Sexo: Mujer", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista del historial
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(2) { index ->
                CardHistorial(
                    titulo = "Fecha: 02/12/2003",
                    numero = "Nivel de glucosa: ${if (index == 0) "200 (mg/dL)" else "130 (mg/dL)"}",
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )

                CardHistorial(
                    titulo = "Hora: ${if (index == 0) "8:00 a.m" else "4:00 a.m"}",
                    numero = "Medicamento de las 8:00 a.m: ${if (index == 0) "Se consumió" else "No se consumió"}",
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }
        }
    }
}
