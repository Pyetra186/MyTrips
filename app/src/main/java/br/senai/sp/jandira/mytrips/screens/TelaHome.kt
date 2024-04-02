package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun TelaHome(){
    MyTripsTheme {
        Box(modifier = Modifier
        ){

            Image(
                painter = painterResource(id = R.drawable.backgroud),
                contentDescription = "Imagem de fundo")

            Column (modifier = Modifier,
                horizontalAlignment = Alignment.End

            ){
                Card (
                    modifier = Modifier
                        .size(width = 60.dp, height = 60.dp),
                    shape = CircleShape,

                    ){

                    Image(
                        painter = painterResource(id = R.drawable.pessoa),
                        contentDescription = "imagem do jogo",
                        contentScale = ContentScale.Crop,

                        )
                    Text(text = "Susanna Hoffs ")
                }
            }
        }
    }
}

@Preview
@Composable
fun TelaHomePreview(){
    TelaHome()
}