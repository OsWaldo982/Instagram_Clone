@file:Suppress("DEPRECATION")

package com.example.jetpackcomposeinstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }

}


@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription ="Close App",
        modifier = modifier.clickable {activity.finish()
        })
}



@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {

        ImageLogo(Modifier.align(CenterHorizontally))
        Spacer(modifier.padding(16.dp))
        Email(email) { email = it }
        Spacer(modifier.padding(4.dp))
        Password(password) { password = it }
        Spacer(modifier.padding(8.dp))
        forgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier.padding(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.padding(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.padding(32.dp))
        SocialLogin()

    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {

        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(12.dp))
        SingUp()
        Spacer(modifier = Modifier.padding(12.dp))

    }
}

@Composable
fun SingUp() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "Don't have an account?",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Sign up.",
            Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

    }
}


@Composable
fun SocialLogin() {
    Row (
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Social login FaceBook", modifier = Modifier.size(20.dp))
        Text(
            text = "Continue as Jose",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = { },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),//Color primario
            disabledContainerColor = Color(0xFF78C8F9),//Color secundario
            contentColor = Color.White,//Color del texto
            disabledContentColor = Color.White//Color del texto
        )
    ) {
        Text(text = "Log In")
    }
}

@Composable
fun forgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {


    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Phone number, username or email", color = Color(0xFF747272))},
        maxLines = 1,//limita el texto a 1 linea
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),//Tipo de teclado al marcar el TextField
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFFAFAFA),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Gray
        )

    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {

    var passwordVisibility by rememberSaveable {
        mutableStateOf(false) }


    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password", color = Color(0xFF747272))},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFFAFAFA),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Gray
        ),
        maxLines = 1,//limita el texto a 1 linea
        singleLine = true,//limita el texto una linea = true
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),//Tipo de teclado al marcar el TextField
        trailingIcon = {
            val imagen = if(passwordVisibility){
                Icons.Filled.VisibilityOff
            }else{
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility}) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        }else {
            PasswordVisualTransformation()
        },
    )
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Logo",
        modifier = modifier
    )
}

