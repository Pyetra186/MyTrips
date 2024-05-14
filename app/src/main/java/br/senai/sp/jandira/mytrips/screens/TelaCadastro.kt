package br.senai.sp.jandira.mytrips.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import br.senai.sp.jandira.mytrips.model.cadastro
import br.senai.sp.jandira.mytrips.repository.CadastroRepository

import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

fun Checkbox(checked: Boolean) {

}

@Composable
fun TelaCadastro(controleNavegacao: NavHostController) {

    val cr = CadastroRepository(LocalContext.current)

    var usernameState = remember {
        mutableStateOf("")
    }

    var phoneState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var passawordState = remember{
        mutableStateOf("")
    }

    var overState = remember {
        mutableStateOf(false)
    }

    MyTripsTheme {

        Column(
            modifier = Modifier.height(950.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.End
            ){
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .background(
                            Color(0xFFCF06F0),
                            shape = RoundedCornerShape(bottomStart = 30.dp)
                        )
                        .width(150.dp)

                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFFCF06F0),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Create a new account",
                    color = Color(0xFFA09C9C)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Card (
                modifier = Modifier
                    .size(height = 100.dp, width = 100.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                elevation = CardDefaults.cardElevation(10.dp),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color.Magenta),
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    imageVector = Icons.Filled.Person,
                    contentDescription = "",
                    tint = Color(0xFFCF06F0)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                value = usernameState.value,
                onValueChange = {
                    Log.i(
                        "username",
                        "Valor: $it"
                    )
                    usernameState.value = it
                },
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = "Username")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedBorderColor = Color(0xFFCF06F0)
                ),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }

            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                value = phoneState.value,
                onValueChange = {
                                Log.i(
                                    "phone",
                                    "valor: $it"
                                )
                    phoneState.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = "Phone")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedBorderColor = Color(0xFFCF06F0)
                ),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }

            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                value = emailState.value,
                onValueChange = {
                                Log.i(
                                    "email",
                                    "valor: $it"
                                )
                    emailState.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = "E-mail")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedBorderColor = Color(0xFFCF06F0)
                ),

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }

            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                value = passawordState.value,
                onValueChange = {
                                Log.i(
                                    "senha",
                                    "valor: $it"
                                )
                    passawordState.value = it
                },
                keyboardOptions =  KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation('*'),
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = "Password")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedBorderColor = Color(0xFFCF06F0)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }
            )

            Spacer(modifier = Modifier.height(13.dp))
            Row(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .align(Alignment.Start),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Checkbox(
                    checked = overState.value,
                    onCheckedChange = {overState.value = it},
                    colors = CheckboxDefaults.colors(Color(0xFFCF06F0)))
                Text(
                    text = "Over 18?",
                )
            }
            Spacer(modifier = Modifier.height(13.dp))
            Button(
                onClick = {
                    var cadastrar = cadastro (
                        nome = usernameState.value,
                        telefone = phoneState.value,
                        email = emailState.value,
                        senha = passawordState.value,
                        maiorIdade = overState.value,
                    )

                    if (usernameState.value == " " ){
                    }else {
                        cr.salvar(cadastro = cadastrar)
                        controleNavegacao.navigate("login")
                    }

                },
                colors = ButtonDefaults
                    .buttonColors(Color(0xFFCF06F0)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                shape = RoundedCornerShape(15.dp),
            ) {
                Text(
                    text = "CREATE ACCOUNT",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier,
                    text = "Already have an account?  ",
                    color = Color(0xFFA09C9C),
                )
                Text(
                    modifier = Modifier.padding(end = 25.dp),
                    text = "Sign up",
                    color = Color(0xFFCF06F0),
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Box (
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)
                    .offset(y = 20.dp)
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

@Preview
@Composable
fun TelaCadastroPreview(){
    //TelaCadastro()
}