package com.example.lifemetrics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonNormal() {
    Button(onClick = { /*TODO*/ }, enabled = false) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormal2() {
    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red
        )
    ) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto() {
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline( onClick: () -> Unit, text: String, backgroundColor: Color, textColor: Color ) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke ( 1.dp, color = Color ( 0xFF6481C1 ) ),
        colors = ButtonDefaults.outlinedButtonColors ( containerColor = backgroundColor )
    ) {
        Text ( text = text, fontSize = 15.sp, color = textColor )
    }
}

@Composable
fun BotonIcono(
    icono: ImageVector,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            icono,
            contentDescription = "Icono",
            tint = Color(0xFF49688D),
            modifier = Modifier.size(40.dp)
        )
    }
}


@Composable
fun BotonSwitch() {
    var switched by remember { mutableStateOf(false) }
    Switch(
        checked = switched, onCheckedChange = { switched = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Green,

            uncheckedThumbColor = Color.Blue,
            uncheckedTrackColor = Color.Magenta
        )
    )
}

@Composable
fun DarkMode(darkMode: MutableState<Boolean>) {
    Button(onClick = { darkMode.value = !darkMode.value }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "DarkMode")
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "Dark Mode", fontSize = 30.sp)
    }
}

@Composable
fun FloatingAction() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}