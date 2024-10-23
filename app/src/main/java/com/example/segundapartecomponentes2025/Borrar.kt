package com.example.segundapartecomponentes2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate


@Composable
fun MyApp() {
    var message by remember { mutableStateOf("") }
    var showText by remember { mutableStateOf(false) }
    var showRadioButtons by remember { mutableStateOf(false) }
    var selectedRadio by remember { mutableStateOf("Opción 1") }
    var imageIndex by remember { mutableStateOf(0) }
    val images = listOf(
        "https://via.placeholder.com/150/0000FF",
        "https://via.placeholder.com/150/FF0000",
        "https://via.placeholder.com/150/00FF00"
    )
    val scope = rememberCoroutineScope()
    var sliderValue by remember { mutableStateOf(50f) }
    var showSnackbar by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf(LocalDate.now().toString()) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ícono permanente
            Icon(Icons.Filled.Star, contentDescription = "Icono permanente")

            Spacer(modifier = Modifier.height(16.dp))

            // Casilla de verificación para mostrar el texto
            Checkbox(checked = showText, onCheckedChange = { showText = it })
            Text("Activar texto")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto visible según la casilla
            if (showText) {
                Text(text = message)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para actualizar el texto y mostrar el CircularProgressIndicator
            Button(onClick = {
                scope.launch {

                    message = "Botón presionado"
                    delay(5000)
                }
                imageIndex = (imageIndex + 1) % images.size
            }) {
                Text("Presionar")
            }

            // Mostrar indicador de carga por 5 segundos
            if (message == "Botón presionado") {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar diálogo al mantener presionado el botón
            Button(onClick = { showDialog = true }) {
                Text("Mantener presionado")
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        Button(onClick = { showDialog = false }) {
                            Text("Cerrar")
                        }
                    },
                    title = { Text("Diálogo") },
                    text = { Text("Este es un diálogo emergente.") }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen dinámica que cambia al hacer clic en el botón
          //  Image(
            //    painter = rememberImagePainter(images[imageIndex]),
            //    contentDescription = "Imagen dinámica",
              //  modifier = Modifier.size(150.dp)
            //)

            Spacer(modifier = Modifier.height(16.dp))

            // Interruptor para mostrar los botones de radio
            Switch(checked = showRadioButtons, onCheckedChange = { showRadioButtons = it })
            Text("Mostrar opciones")

            // Grupo de botones de radio
            if (showRadioButtons) {
                val radioOptions = listOf("Opción 1", "Opción 2", "Opción 3")
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedRadio),
                                onClick = { selectedRadio = text }
                            )
                            .padding(horizontal = 16.dp)
                    ) {
                        RadioButton(
                            selected = (text == selectedRadio),
                            onClick = { selectedRadio = text }
                        )
                        Text(text = text, modifier = Modifier.padding(start = 8.dp))
                    }
                }
                message = selectedRadio
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Slider
            Slider(value = sliderValue, onValueChange = { sliderValue = it })
            Text("Valor del slider: ${sliderValue.toInt()}")

            Spacer(modifier = Modifier.height(16.dp))

            // Selector de fecha
            Button(onClick = { showDatePicker = true }) {
                Text("Seleccionar fecha")
            }

            if (showDatePicker) {
                DatePickerDialog(onDateSelected = {
                    selectedDate = it.toString()
                    showDatePicker = false
                })
            }

            Text("Fecha seleccionada: $selectedDate")
        }
    }


@Composable
fun DatePickerDialog(onDateSelected: (LocalDate) -> Unit) {
    // Lógica para mostrar un selector de fecha
}
