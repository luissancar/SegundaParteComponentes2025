package com.example.segundapartecomponentes2025

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(checked = state, onCheckedChange = { state = it }, enabled = true,  colors = SwitchDefaults.colors(
        checkedThumbColor = Color.Green,   // Color del "thumb" cuando está activado
        checkedTrackColor = Color.LightGray,  // Color del "track" cuando está activado
        uncheckedThumbColor = Color.Red,   // Color del "thumb" cuando está desactivado
        uncheckedTrackColor = Color.Gray   // Color del "track" cuando está desactivado
    )
    )
}