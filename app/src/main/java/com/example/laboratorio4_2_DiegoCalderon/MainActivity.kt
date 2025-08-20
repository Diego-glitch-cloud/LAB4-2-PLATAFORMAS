package com.example.laboratorio4_2_DiegoCalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio4_2_DiegoCalderon.ui.theme.Laboratorio4_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var receta by remember { mutableStateOf("") }
                    var url by remember { mutableStateOf("") }
                    val listaRecetas = remember { mutableStateListOf<String>() }

                    Row(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f) // Esto hace que ocupe todo el espacio disponible
                        ) {
                            TextField(
                                value = receta,
                                onValueChange = { receta = it },
                                label = { Text("Nombre de la Receta") }
                            )
                            TextField(
                                value = url,
                                onValueChange = { url = it },
                                label = { Text("URL de la imagen") }
                            )
                        }

                        Button(
                            onClick = {
                                // Lógica para agregar a la lista
                            }
                        ) {
                            Text("Agregar receta")
                        }
                    }
                }
            }
        }
    }
}