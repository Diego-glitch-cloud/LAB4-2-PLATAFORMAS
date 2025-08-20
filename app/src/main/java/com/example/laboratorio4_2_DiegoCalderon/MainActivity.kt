package com.example.laboratorio4_2_DiegoCalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.laboratorio4_2_DiegoCalderon.ui.theme.Laboratorio4_2Theme
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4_2Theme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    // Variables para almacenar los datos de la receta
                    var receta by remember { mutableStateOf("") }
                    var url by remember { mutableStateOf("") }
                    val listaRecetas = remember { mutableStateListOf<String>() }

                    Column (
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        TextField(
                            value = receta,
                            onValueChange = { receta = it }, // Actualiza el valor de receta dependiendo de lo que se ingrese
                            label = { Text("Nombre de la Receta") }
                        )
                        TextField(
                            value = url,
                            onValueChange = { url = it },
                            label = { Text("URL de la imagen")}
                        )
                    }
                }
            }
        }
    }
}

