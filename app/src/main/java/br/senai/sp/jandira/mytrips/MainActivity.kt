package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   
                }
            }
        }
    }
}
@Composable
fun Login () {
    Surface (modifier = Modifier .fillMaxSize())
    {
        Column {
            Card (modifier = Modifier
                .size(130.dp, 40.dp)
                .align(Alignment.End),
                colors = CardDefaults.cardColors(Color(0xFFCF06F8)),
                shape = RoundedCornerShape(bottomStart = 16.dp)
            ){}
        }
        Column (modifier = Modifier
            .padding(start = 25.dp, top = 160.dp)
        ) {
            Text(
                text = "Login",
                color = Color(0xFFCF06F8),
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
            )

            Text(text = "Please sign in to continue.",
                color = Color(0xFFA09C9C)
            )

        }

        Column (

        ){
            Button(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffCF06F0))

            ) {
                Row  (
                    modifier = Modifier
                        .width(150.dp)
                        .height(48.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text(text = "Sing in",
                        fontSize = 26.sp
                    )

                }
            }

        }
    }

}

@Composable
    fun Greeting(){
        Box(modifier = Modifier

        ){
            Image(
                painter = painterResource(id = R.drawable.backgroud),
                contentDescription = "Imagem de fundo")
            Column {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "icone de localizacao",
                        tint = Color.White
                    ),
                    Text(
                        text = "You're in Paris",
                        color = Color.White
                    ),

                    )

            }

        }
}

fun OutlinedTextField(modifier: Modifier, icon: Unit, text: Unit) {

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomePreview() {
    MyTripsTheme {
        Greeting()
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TesteColumnPreview() {
    MyTripsTheme {
        Login()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTripsTheme {

    }
}