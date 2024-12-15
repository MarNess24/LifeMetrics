package com.example.navigateprojects.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lifemetrics.actividad.eliminarPaciente
import com.example.lifemetrics.components.BotonIcono
import com.example.lifemetrics.conexion.SessionManager
import com.example.lifemetrics.data.Paciente

@Composable
fun DosTarjetas(titulo1: String, numero1: String, titulo2: String, numero2: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MainCard (
            titulo = titulo1,
            numero = numero1,
            modifier = Modifier
                .padding(30.dp)
                .weight(1f)
        )

        SpaceW(10.dp)

        MainCard (
            titulo = titulo2,
            numero = numero2,
            modifier = Modifier
                .padding(30.dp)
                .weight(1f)
        )

    }
}

@Composable
fun MainCard (titulo: String, numero: String, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ){
            Text(text = titulo, color = Color.Black, fontSize = 20.sp)
            Text(text = "$$numero", color = Color.Black, fontSize = 20.sp)
        }
    }
}

@Composable
fun PersonCard(
    name: String,
    navController: NavController,
    id: String,
    edad: String,
    sexo: String,
    peso: String,
    altura: String,
    sessionManager: SessionManager,
    onEliminar: (String) -> Unit,  // Función para manejar la eliminación
    onHistorial: (String, String, String, String, String, String) -> Unit,  // Función para manejar el historial
    onRegistro: (String) -> Unit    // Función para manejar los registros
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB0C1D9))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF49688D)
            )

            Row {
                // Botón para registrar consumo
                BotonIcono(
                    Icons.Default.Edit,
                    onClick = { onRegistro(id)}
                )
                Spacer(modifier = Modifier.width(5.dp))

                // Botón para acceder al historial
                BotonIcono(
                    icono = Icons.Default.DateRange,
                    onClick = { onHistorial(id, name, edad, sexo, peso, altura) }
                )
                Spacer(modifier = Modifier.width(5.dp))

                // Botón para eliminar el usuario
                BotonIcono(
                    icono = Icons.Default.Delete,
                    onClick = { onEliminar(id) } // Llama a la función onEliminar con el id
                )
            }
        }
    }
}


@Composable
fun CardHistorial(fecha: String, Hora: String, glucosa: String, ArterialS: String, ArterialD: String ,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE6EBF5))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = fecha, color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = Hora, color = Color.Black, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = glucosa, color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = ArterialS, color = Color.Black, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = ArterialD, color = Color.Black, fontSize = 16.sp)
        }
    }
}