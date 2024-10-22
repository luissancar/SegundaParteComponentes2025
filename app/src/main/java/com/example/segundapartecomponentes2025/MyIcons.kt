package com.example.segundapartecomponentes2025

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun MyIcon() {
    Button(onClick = {}) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(  // es parte de material desing 24x24
                //fonts.google.com/icons, hay una libreria que ocupa mucho
                imageVector = Icons.Rounded.Star,
                contentDescription = "Icoco",
                tint = Color.Blue
            )
            Text("Star")
        }
    }

}