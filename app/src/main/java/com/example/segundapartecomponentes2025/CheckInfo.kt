package com.example.segundapartecomponentes2025

data class CheckInfo(
    val titulo: String,
    var seleccionado: Boolean = false,
    var cambiado: (Boolean) -> Unit
)