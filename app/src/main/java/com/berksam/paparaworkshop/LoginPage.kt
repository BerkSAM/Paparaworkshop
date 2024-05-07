package com.berksam.paparaworkshop

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onLogin: (email: String, password: String) -> Unit = { _, _ -> }
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(true) }

    Scaffold(
        //modifier = modifier.background(color = Purple40),
        modifier = modifier,
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo"
                )
                Text(
                    text = "Welcome to Example App",
                    modifier = Modifier.padding(8.dp)
                )
                //text field
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    visualTransformation = if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    trailingIcon = {
                        Image(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable { passwordVisible = !passwordVisible },
                            painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                            contentDescription = "PasswordVisibilityButton"
                        )
                    }
                )

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = { onLogin(email, password) }
                ) {
                    Text(text = "Login")
                }

                ElevatedButton(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color = Color.Transparent),
                    onClick = { }
                ) {
                    Text("Forgot Password")
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(
        Modifier,
        onLogin = { email, password ->
            //do
            Log.v("LoginPage", "Email: $email, password: $password")
        }
    )
}