package com.berksam.paparaworkshop

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onLogin: (email: String, password: String) -> Unit = {_, _ ->}
) {
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var passwordVisible by remember { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo")
        Text(text = "Papara Bootcamp",
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .padding(8.dp))
        //text field
        TextField(
            value = email, onValueChange = {
                email = it
        },
            label = { Text("Email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))

        TextField(
            value = password, onValueChange = {
                password = it
            },
            visualTransformation = if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Password")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                Image(
                    modifier = Modifier.padding(8.dp).clickable { passwordVisible = !passwordVisible  },
                    painter = painterResource(id = R.drawable.baseline_attach_money_24),
                    contentDescription = "PasswordVisibilityButton")
            })

        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { passwordVisible = !passwordVisible }
        ) {
            Text(if(passwordVisible) "Show Password"  else "Hide Password")
        }

        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { onLogin(email,password) }
            ) {
            Text(text = "Login")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview(){
    LoginPage(
        Modifier,
        onLogin = { email, password ->
            //do
            Log.v("LoginPage" , "Email: $email, password: $password")
        }
    )
}