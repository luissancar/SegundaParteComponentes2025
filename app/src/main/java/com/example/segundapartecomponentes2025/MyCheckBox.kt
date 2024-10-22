package com.example.segundapartecomponentes2025

import android.widget.CheckBox
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.selects.select

@Composable
fun MyCheckBox() {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("CheckBox")
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,      // Color cuando está marcado
                uncheckedColor = Color.Red,     // Color cuando está desmarcado
                checkmarkColor = Color.White    // Color del símbolo de check
            )
        )
    }

}

@Composable
fun MyCheckBoxState(titulo: String) {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,      // Color cuando está marcado
                uncheckedColor = Color.Red,     // Color cuando está desmarcado
                checkmarkColor = Color.White    // Color del símbolo de check
            )
        )

        Text(titulo)
    }

}


@Composable
fun MyCheckBoxStateF(checkInfo: CheckInfo) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.seleccionado,
            onCheckedChange = { checkInfo.cambiado(!checkInfo.seleccionado) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,      // Color cuando está marcado
                uncheckedColor = Color.Red,     // Color cuando está desmarcado
                checkmarkColor = Color.White    // Color del símbolo de check
            )
        )
        Text(checkInfo.titulo)
    }
}


@Composable
fun MyCheckBoxMain() {

    var status1 by rememberSaveable { mutableStateOf(false) }
    var status2 by rememberSaveable { mutableStateOf(false) }
    var status3 by rememberSaveable { mutableStateOf(false) }
    val checkBox1 = CheckInfo("Uno",
        seleccionado = status1,
        cambiado = { status1 = it })
    val checkBox2 = CheckInfo("Dos",
        seleccionado = status2,
        cambiado = { status2 = it })
    val checkBox3 = CheckInfo("Tres",
        seleccionado = status3,
        cambiado = { status3 = it })
    Column {
        MyCheckBoxStateF(checkBox1)
        MyCheckBoxStateF(checkBox2)
        MyCheckBoxStateF(checkBox3)
        if (status1)
            Text("Uno")
        if (status2)
            Text("Dos")
        if (status3)
            Text("Tres")
    }

}


@Composable
fun MyCheckBoxMain2() {
    val opciones = GetOptions(listOf("Uno", "Dos", "Tres","cuatro"))
    Column {
        opciones.forEach {
            MyCheckBoxStateF(it)
        }
        opciones.forEach {
            if (it.seleccionado)
                Text(it.titulo)
        }
    }
}

@Composable
fun GetOptions(titulos: List<String>): List<CheckInfo> {

    return titulos.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            titulo = it,
            seleccionado = status,
            cambiado = { status = it }
        )
    }


}
























































