package br.senai.sp.jandira.mytrips.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.room.Database
import br.senai.sp.jandira.mytrips.repository.CadastroRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun TelaLogin(controleNavegacao: NavHostController) {
    MyTripsTheme {

        val cr = CadastroRepository(LocalContext.current)

        var emailState = remember {
            mutableStateOf("")
        }

        var senhaState = remember {
            mutableStateOf("")
        }

        val emailContext = LocalContext.current


        Column {
            Card(
                modifier = Modifier
                    .size(130.dp, 40.dp)
                    .align(Alignment.End),
                colors = CardDefaults.cardColors(Color(0xffCF06F0)),
                shape = RoundedCornerShape(bottomStart = 16.dp)
            ){}
            Column(
                modifier = Modifier
                    .padding(start = 25.dp, top = 130.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color(0xffCF06F0),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.ExtraBold,

                    )
                Text(
                    text = "Please sign in to continue.",
                    color = Color(0xffA09C9C)
                )
            }
            Spacer(modifier = Modifier
                .padding(bottom = 60.dp,top = 30.dp)
            )
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    Log.i(
                        "email",
                        "Valor: $it"
                    )
                    emailState.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = "email")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(327.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xffCF06F0),
                    focusedBorderColor = Color(0xffCF06F0),
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "lock",
                        modifier = Modifier
                            .offset(y=-0.dp),
                        tint = Color(0xffCF06F0)
                    )
                }

            )
            Spacer(modifier = Modifier .padding(30.dp))

            OutlinedTextField(

                value = senhaState.value,
                onValueChange = {
                    Log.i(
                        "senha",
                        "Valor: $it"
                    )
                    senhaState.value = it
                },
                keyboardOptions =  KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation('*'),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = "password")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(330.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xffCF06F0),
                    focusedBorderColor = Color(0xffCF06F0),
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "lock",
                        modifier = Modifier
                            .offset(y=-0.dp),
                        tint = Color(0xffCF06F0)
                    )
                }
            )
            Spacer(modifier = Modifier .padding(20.dp))

            Button(onClick = {
                if (emailState.value.isNotEmpty() && senhaState.value.isNotEmpty()) {
                    val user = cr.login(emailState.value, senhaState.value)
                    if (user != null) {
                        controleNavegacao.navigate("home")
                    } else {
                        Toast.makeText(
                            emailContext,
                            "ERRO! email ou senha inválidos",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
               }
            },
                modifier = Modifier
                    .size(134.dp, 48.dp)
                    .align(Alignment.End)
                    .offset(x = -35.dp)
                    .padding(top = 10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffCF06F0)),
                shape = RoundedCornerShape(16.dp)

            ) {
                Text(
                    text = "SING IN",
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = Icons.Default.Email, contentDescription = "",
                    modifier = Modifier
                        .offset(y = -0.dp),
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){

                Text(
                    modifier = Modifier,
                    text = "Don’t have an account?  ",
                    color = Color(0xFFA09C9C)
                )
                Button(
                    onClick = {
                        controleNavegacao.navigate("Cadastro") },
                    modifier = Modifier
                       ,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),

                )
                {
                    Text(
                        modifier = Modifier.padding(end = 25.dp),
                        text = "Sign up",
                        color = Color(0xFFCF06F0),
                        fontWeight = FontWeight.Bold,

                    )
                }


            }
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)
                    .offset(y = 75.dp)
                    .background(
                        Color(0xFFCF06F0),
                        shape = RoundedCornerShape(topEnd = 30.dp)
                    )
                    .padding(top = 90.dp)
            ){

            }

        }
    }
}

@Composable
fun Spacer(modifier: Modifier) {

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TelaLoginPreview() {
    MyTripsTheme {

        //TelaLogin
    }
}