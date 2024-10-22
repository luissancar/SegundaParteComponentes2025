package com.example.segundapartecomponentes2025

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = Color.Red,
            strokeWidth = 5.dp
        )
        LinearProgressIndicator(
            Modifier.padding(top = 40.dp),
            color = Color.Yellow,
            trackColor = Color.Blue
        )
    }

}

@Composable
fun MyProgressBar2() {
    var show by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (show) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 5.dp
            )
            LinearProgressIndicator(
                Modifier.padding(top = 40.dp),
                color = Color.Yellow,
                trackColor = Color.Blue
            )
        }

        Button(onClick = { show = !show }) { Text("Show") }
    }
}


@Composable
fun MyProgressBar3() {
    var pro by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = { 1f - pro }
        )
        CircularProgressIndicator(
            progress = { pro },
        )
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { pro += 0.1f }) {
                Text("Incrementar")
            }
            Button(onClick = { pro -= 0.1f }) {
                Text("Decrementar")
            }
        }
    }
}


















