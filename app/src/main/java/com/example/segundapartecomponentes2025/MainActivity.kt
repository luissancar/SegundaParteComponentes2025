package com.example.segundapartecomponentes2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.segundapartecomponentes2025.ui.theme.SegundaParteComponentes2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SegundaParteComponentes2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
       // MyIcon()
        //MyProgressBar3()
        //MySwitch()
        //MyCheckBox()
        //MyCheckBoxMain()
     //   MyCheckBoxMain2()
       //MyTriStatusChecbox()
       // MyRadioButton()
        MyRadioButtonMain()


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SegundaParteComponentes2025Theme {
        Greeting("Android")
    }
}