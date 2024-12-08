package com.example.navigateprojects.components

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 25.sp, color = Color.White)
}

@Composable
fun ActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color( 0xFF6481C1 ),
        contentColor = Color.White,
        shape = CircleShape,
        modifier = Modifier.size( 80.dp ).offset(y = (-100).dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar",
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun MainIconButton ( icon: ImageVector, onClick:() -> Unit ) {
    IconButton ( onClick = onClick ) {
        Icon ( imageVector = icon, contentDescription = null, tint = Color.White )
    }
}