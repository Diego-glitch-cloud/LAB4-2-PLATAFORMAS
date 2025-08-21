package com.example.laboratorio4_2_DiegoCalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.laboratorio4_2_DiegoCalderon.ui.theme.Laboratorio4_2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4_2Theme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var receta by remember { mutableStateOf("") }
                    var url by remember { mutableStateOf("") }
                    val listaRecetas = remember { mutableStateListOf<Receta>() }

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                            ){
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
                                    val nuevaReceta = Receta(receta, url)
                                    if (receta.isNotBlank() && url.isNotBlank() && !listaRecetas.contains(nuevaReceta)) {
                                        listaRecetas.add(nuevaReceta)
                                        receta = ""
                                        url = ""
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                                modifier = Modifier.fillMaxHeight()
                            ) {
                                Text("Agregar receta", fontSize = 18.sp)
                            }
                        }

                        LazyColumn(
                            modifier = Modifier.weight(1f)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            items(listaRecetas) { receta ->
                                RecetaCard(receta = receta)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun RecetaCard(receta: Receta) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = receta.imageUrl,
                contentDescription = "Imagen de la receta ${receta.nombre}",
                modifier = Modifier.size(300.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = receta.nombre,
                fontSize = 30.sp,
                modifier = Modifier.padding(top=8.dp)
            )
        }
    }
}