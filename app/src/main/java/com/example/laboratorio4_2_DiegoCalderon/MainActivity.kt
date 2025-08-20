package com.example.laboratorio4_2_DiegoCalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.laboratorio4_2_DiegoCalderon.ui.theme.Laboratorio4_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4_2Theme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    ////////////////////////////
                    ////////
                }
            }
        }
    }
}

