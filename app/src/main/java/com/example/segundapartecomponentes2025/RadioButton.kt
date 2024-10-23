package com.example.segundapartecomponentes2025

import android.widget.RadioButton
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButtonSolo() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false, onClick = {}, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Yellow,
                disabledUnselectedColor = Color.Cyan
            )
        )
        Text("RadioButton")
    }
}


@Composable
fun MyRadioButton() {
    var selected by rememberSaveable { mutableStateOf("a") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "a", onClick = { selected = "a" })
        Text("a")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "b", onClick = { selected = "b" })
        Text("b")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "c", onClick = { selected = "c" })
        Text("c")
    }
}


@Composable
fun MyRadioButtonLa(selected: String, itemSeleccionado: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "a", onClick = { itemSeleccionado("a") })
        Text("a")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "b", onClick = { itemSeleccionado("b") })
        Text("b")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "c", onClick = { itemSeleccionado("c") })
        Text("c")
    }
}

@Composable
fun MyRadioButtonMain() {
    var selec by rememberSaveable { mutableStateOf("a") }
    MyRadioButtonLa(selec) { selec = it }
    when(selec){
        "a"-> Text("a")
        "b"-> Text("b")
        "c"-> Text("c")
    }
}































