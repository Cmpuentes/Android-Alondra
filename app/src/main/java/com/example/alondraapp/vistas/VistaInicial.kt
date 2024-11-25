package com.example.alondraapp.vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.alondraapp.R

@Composable
fun VistaDeInicio(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF4EBFC))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Titulo
        Text(
            text = "Bienvenido a la app de ventas, Alondra",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        //Subtitulo
        Text(
            text = "Explora nuestros productos y encuentra lo que necesitas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(25.dp))

        //Imagen no logo
        Image(
            painter = painterResource(id = R.drawable.boutique),
            contentDescription = "imagen de inicio"
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Botón para pasar a la siguiente vista
        Button(onClick = { navController.navigate("Detail") }) {
            Text(text = "Ir a la tienda")
        }
    }
}

