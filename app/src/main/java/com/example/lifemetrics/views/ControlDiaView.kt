package com.example.lifemetrics.views

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lifemetrics.R
import com.example.lifemetrics.actividad.enviarRegistro
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ControlDiaView(navController: NavController, id: String) {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),  // Mueve la imagen hacia abajo
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.registro),
                    contentDescription = "registro",
                    modifier = Modifier.size(250.dp)  // Ajusta el tamaño de la imagen
                )
                ContentControlDiaView(navController, id)
            }
            Image(
                painter = painterResource(id = R.drawable.piepagcontroldia),
                contentDescription = "piepag",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentControlDiaView(navController: NavController, id: String) {
    //var isChecked by remember { mutableStateOf(false) }
    //var isChecked2 by remember { mutableStateOf(false) }

    // Variables para los diálogos de fecha y hora
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }

    var glucosa by remember { mutableStateOf("") }
    var presionsistolica by remember { mutableStateOf("") }
    var presiondiastolica by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }
    var mensajeExito by remember { mutableStateOf("") }



    // Función para mostrar el DatePicker
    val context = LocalContext.current

    fun validateGlucosa(value: String): String {
        return if (value.all { it.isDigit() }) value else glucosa
    }

    fun validateSistolica(value: String): String {
        return if (value.all { it.isDigit() }) value else presionsistolica
    }

    fun validateDiastolica(value: String): String {
        return if (value.all { it.isDigit() }) value else presiondiastolica
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Control del día",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF49688d),
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para la fecha con un botón para abrir el DatePicker
            OutlinedTextField(
                value = fecha,
                onValueChange = { },
                label = { Text("Fecha") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { showDatePicker(context, { selectedDate -> fecha = selectedDate }) },
                readOnly = true,  // Hace que el campo sea solo lectura
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF49688d),
                    unfocusedBorderColor = Color(0xFF8aa2d4),
                    focusedLabelColor = Color(0xFF49688d),
                    unfocusedLabelColor = Color(0xFF8aa2d4),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para la hora con un botón para abrir el TimePicker
            OutlinedTextField(
                value = hora,
                onValueChange = { },
                label = { Text("Hora") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { showTimePicker(context, { selectedTime -> hora = selectedTime }) },
                readOnly = true,  // Hace que el campo sea solo lectura
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF49688d),
                    unfocusedBorderColor = Color(0xFF8aa2d4),
                    focusedLabelColor = Color(0xFF49688d),
                    unfocusedLabelColor = Color(0xFF8aa2d4),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = glucosa,
                onValueChange = { glucosa = validateGlucosa(it) },
                label = { Text("Nivel de glucosa") },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF49688d),
                    unfocusedBorderColor = Color(0xFF8aa2d4),
                    focusedLabelColor = Color(0xFF49688d),
                    unfocusedLabelColor = Color(0xFF8aa2d4),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = presionsistolica,
                onValueChange = { presionsistolica = validateSistolica(it) },
                label = { Text("Presión Arterial Sistólica") },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF49688d),
                    unfocusedBorderColor = Color(0xFF8aa2d4),
                    focusedLabelColor = Color(0xFF49688d),
                    unfocusedLabelColor = Color(0xFF8aa2d4),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = presiondiastolica,
                onValueChange = { presiondiastolica = validateDiastolica(it) },
                label = { Text("Presión Arterial Diastólica") },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF49688d),
                    unfocusedBorderColor = Color(0xFF8aa2d4),
                    focusedLabelColor = Color(0xFF49688d),
                    unfocusedLabelColor = Color(0xFF8aa2d4),
                )
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                enviarRegistro(
                    pacienteId = id,
                    fecha = fecha,
                    hora = hora,
                    glucosa = glucosa,
                    presionSistolica = presionsistolica,
                    presionDiastolica = presiondiastolica,
                    onSuccess = {
                        // Mensaje de éxito o navegación
                        mensajeExito = "Registro registrado exitosamente"
                        mensajeError = ""
                        navController.popBackStack()
                    },
                    onError = { errorMessage ->
                        mensajeError = errorMessage
                        mensajeExito = ""
                        // Muestra un mensaje de error (opcionalmente puedes agregar un Snackbar)
                        //println("Error: $errorMessage")
                    })
            },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8aa2d4)
                )) {
                Text(
                    text = "Registrar",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(5.dp)) // Añadir un espacio antes de la imagen
                // Mostrar mensajes de error o éxito
                if (mensajeExito.isNotEmpty()) {
                    Text(
                        text = mensajeExito,
                        color = Color.Green,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                if (mensajeError.isNotEmpty()) {
                    Text(
                        text = mensajeError,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp)) // Añadir un espacio antes de la imagen

            }

            /*
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "¿Consumiste tu medicamento?",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF49688d),
                fontSize = 18.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF49688d),
                        uncheckedColor = Color(0xFF8aa2d4)
                    )
                )
                Text(text = "medicamento 1")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked2,
                    onCheckedChange = { isChecked2 = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF49688d),
                        uncheckedColor = Color(0xFF8aa2d4)
                    )
                )
                Text(text = "medicamento 2")
            }
            */
        }
    }
}

    // Función para mostrar el DatePicker
    fun showDatePicker(context: android.content.Context, onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"  // Formato de fecha
                onDateSelected(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    // Función para mostrar el TimePicker
    fun showTimePicker(context: android.content.Context, onTimeSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)  // Formato de hora
                onTimeSelected(selectedTime)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }


