package com.example.alondraapp.vistas

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.alondraapp.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaDeProductos(navController: NavController){
    Scaffold(
        topBar = { Toolbar()}
    ){ innerPadding ->
        Content(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_menu),
                    contentDescription = "icono de menu"
                )

                Spacer(modifier = Modifier.width(8.dp))

                val searchQuery = remember {
                    mutableStateOf(TextFieldValue("Buscar"))
                }
                BasicTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.LightGray, MaterialTheme.shapes.small)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(id = R.drawable.icon_carrito),
                    contentDescription = "icono de carrito"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = Color(0xFFF4EBFC))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_zapatos),
                    contentDescription = "Producto Destacado",
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Producto Destacado",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Descripción breve del producto destacado.",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Comprar")
                    }
                }
            }
        }
        LazyRow {
            items(8){index ->
                Column (
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color = Color(0xFFD9B4F9))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = getImageResource(index)),
                        contentDescription = "image #$index",
                        modifier = Modifier.size(40.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Categorias",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn (
            modifier = Modifier.fillMaxSize()
        ){
            items(10){index ->
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ){
                        Image(
                            painter = painterResource(id = getImageResourceColumn(index)),
                            contentDescription = "image #$index",
                            modifier = Modifier.size(64.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column (
                            modifier = Modifier.weight(1f)
                        ){
                            Text(
                                text = "Producto",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "Descripción dle producto",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }

    }
}

@DrawableRes
fun getImageResourceColumn(index: Int): Int{
    val imageResourceColumn = listOf(
        R.drawable.zapatosdehombre,
        R.drawable.sombrero,
        R.drawable.taconesaltos,
        R.drawable.saltador,
        R.drawable.shortsdemezclilla,
        R.drawable.taconesaltos,
        R.drawable.camisa,
        R.drawable.zapatos_deportivos,
        R.drawable.pantalones,
        R.drawable.pulsera
    )
    return imageResourceColumn[index % imageResourceColumn.size]
}

@DrawableRes
fun getImageResource(index:Int): Int{
    val imageResource = listOf(
        R.drawable.oferta,
        R.drawable.bolso,
        R.drawable.camisa,
        R.drawable.collares,
        R.drawable.pantalones,
        R.drawable.sombrero,
        R.drawable.pulsera
    )
    return imageResource[index % imageResource.size]
}


@Preview(showBackground = true)
@Composable
fun Visualizacion(){

}