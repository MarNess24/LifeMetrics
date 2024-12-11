package com.example.navigateprojects.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar( name: String, textColor: Color, backgroundColor: Color, image: Int ) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .background( backgroundColor )
            .height( 150.dp )
            .padding( 16.dp )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Imagen
            Image (
                painter = painterResource ( id = image ),
                contentDescription = "Logo",
                modifier = Modifier.size( 120.dp )
            )

            Spacer ( modifier = Modifier.width ( 10.dp ) )

            // Título
            Text (
                text = name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
    }
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
        Icon (
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