package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.CategoriasRepository
import br.senai.sp.jandira.mytrips.repository.tripsRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome() {

    var searchState = remember {
        mutableStateOf("")
    }

    val viagens = tripsRepository().listarTodasAsViagens(LocalContext.current)
    val categorias = CategoriasRepository().listarTodasCategorias(LocalContext.current)



    MyTripsTheme {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RectangleShape
            ) {

                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.backgroud),
                        contentDescription = "",


                    )


                    Column(
                        modifier = Modifier
                            .padding(start = 18.dp, end = 16.dp, top = 12.dp, bottom = 5.dp),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {

                            Card(
                                modifier = Modifier.size(60.dp),
                                shape = RoundedCornerShape(50.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.pessoa),
                                    modifier = Modifier.fillMaxSize(),
                                    contentDescription = ""
                                )
                            }
                            Text(
                                text = "Susanna Hoffs",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(bottom = 12.dp),

                        ) {
                            Row(modifier = Modifier) {
                                Icon(
                                    Icons.Default.LocationOn,
                                    contentDescription = "Localizacao",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(18.dp)
                                        .offset(y = 5.dp)
                                )
                                Text(
                                    text = "You're in Paris",
                                    color = Color.White,
                                    letterSpacing = (-0.5).sp,
                                    fontSize = 15.sp,
                                    modifier = Modifier.offset(y = 4.dp)
                                )
                            }
                            Text(
                                text = "My Trips",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                letterSpacing = -1.sp,
                                modifier = Modifier



                            )

                        }
                    }
                }

            }
 Column {

    Column (
        modifier = Modifier

    ){
        Text(
            text = "Categories",
            textAlign = TextAlign.Start,
            color = Color.Gray,
            modifier = Modifier.padding(top = 210.dp, start = 16.dp),
        )

        Spacer(modifier = Modifier.height(20.dp))
        LazyRow() {
            items(categorias){
                Card (
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 8.dp, start = 10.dp, top = 15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xffCF06F0)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ){

                        Image(
                            painter = if(it.img == null) painterResource(id = R.drawable.no_img) else it.img!!,
                            contentDescription = "")
                        Text(
                            text = it.nome,
                            color = Color.White,
                            fontSize = 14.sp
                        )

                    }

                }
            }
        }
    }

    Column {
        SearchBar(
            query = searchState.value,
            onQueryChange = {
                searchState.value = it
            },
            onSearch = {},
            active = false,
            onActiveChange = {},
            colors = SearchBarDefaults.colors(containerColor = Color(0xFFDEDCDF)),
            shape = RoundedCornerShape(15.dp),
            trailingIcon = {
                Icon(Icons.Outlined.Search, contentDescription = "", tint = Color.Gray)
            },
            placeholder = {
                Text(text = "Search your destiny...",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            },
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp)
                .height(50.dp),

            )
        {}
    }
    Column {
        LazyColumn(){
            items(viagens){
                Column (modifier = Modifier
                    .fillMaxWidth()
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    Card (modifier = Modifier
                        .size(350.dp, 230.dp)
                        .padding(vertical = 8.dp)
                        ,
                        colors = CardDefaults.cardColors(Color(0xFFDEDCDF)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, color = Color.White)
                    ){
                        Column (modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally

                        ){

                            Card (modifier = Modifier
                                .height(106.dp)
                                .width(330.dp)
                            ){

                                Image(
                                    painter = if(it.imagem == null) painterResource(id = R.drawable.no_img) else it.imagem!!,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))
                            Column (modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.Start
                            ) {

                                Text(text = it.destino,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xffCF06F0)
                                )

                                Text(text = it.descricao,
                                    fontSize = 12.sp,
                                    lineHeight = 15.sp,
                                    modifier = Modifier.padding(top = 6.dp)

                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ){

                                Text(text = "18 Feb - 21 - Feb",
                                    color = Color(0xffCF06F0),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    modifier = Modifier.padding(top = 18.dp)

                                )
                            }
                        }

                    }
                }
            }
        }
    }
        }



        }
    }




@Preview (showSystemUi = true)
@Composable
fun TelaHomePreview(){
    TelaHome()
    //TelaHome(controleNavegacao)
}