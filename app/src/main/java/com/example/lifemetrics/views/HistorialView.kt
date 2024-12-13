package com.example.lifemetrics.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.navigateprojects.components.CardHistorial

@Composable
fun HistorialScreen(navController: NavController) {
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

            Box(
                modifier = Modifier
                    .clickable { navController.popBackStack() }
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
                Text(text = "Nombre: María", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Edad: 65", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Sexo: Mujer", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
                Text(text = "Altura: 1.56m", fontWeight = FontWeight.Bold, color = Color(0xFF5A5A5A))
            }

            Spacer(modifier = Modifier.height(16.dp))


            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(2) { index ->
                    CardHistorial(
                        fecha = "Fecha: 02/12/2003",
                        Hora = "Nivel de glucosa: 200 (mg/dL)",
                        glucosa = "Hora: ${if (index == 0) "8:00 a.m" else "4:00 a.m"}",
                        ArterialS = "Presión arterial Sistólica: ",
                        ArterialD = "Presión arterial Diastólica: ",
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    CardHistorial(
                        fecha = "Fecha: 02/12/2003",
                        Hora = "Nivel de glucosa: 200 (mg/dL)",
                        glucosa = "Hora: ${if (index == 0) "8:00 a.m" else "4:00 a.m"}",
                        ArterialS = "Presión arterial Sistólica: ",
                        ArterialD = "Presión arterial Diastólica: ",
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    CardHistorial(
                        fecha = "Fecha: 02/12/2003",
                        Hora = "Nivel de glucosa: 200 (mg/dL)",
                        glucosa = "Hora: ${if (index == 0) "8:00 a.m" else "4:00 a.m"}",
                        ArterialS = "Presión arterial Sistólica: ",
                        ArterialD = "Presión arterial Diastólica: ",
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }
        }
    }
}
