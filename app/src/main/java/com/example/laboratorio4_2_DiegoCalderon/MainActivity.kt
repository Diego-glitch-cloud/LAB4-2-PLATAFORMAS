package com.example.laboratorio4_2_DiegoCalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
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
                                // TODO tomar los valores de receta y url
                                // Agregarlos a listaRecetas
                                // Borrar el texto de los campos para que se puedan ingresar nuevos

                                if (receta.isNotBlank() && !listaRecetas.contains(receta)) { // Verificación
                                    listaRecetas.add(receta)

                                    // Se limpian los campos
                                    receta = ""
                                    url = ""
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Green) // Boton Verde
                        ) {
                            Text("Agregar receta")
                        }

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Mostrar lazy column
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                items(listaRecetas) { receta -> Text(text = receta) }
                            }
                        }


                    }
                }
            }
        }
    }
}