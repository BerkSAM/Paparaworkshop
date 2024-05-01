package com.berksam.paparaworkshop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.berksam.paparaworkshop.ui.theme.PaparaworkshopTheme
import com.berksam.paparaworkshop.ui.theme.Purple40

class MainActivity : ComponentActivity() {

    private var nameState = mutableStateOf("Android x Papara Workshop")
    private var name = "Android"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("mainActivity", "onCreate called ${nameState.value}")
        nameState.value = "Android x Papara WorkShop"
        setContent {
            PaparaworkshopTheme {
                LaunchedEffect(nameState.value) {
                    Log.v("MainActivity","Launched effect called by ${nameState.value}")
                }



                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),color = Purple40) {
                    LoginPage(
                        modifier = Modifier.padding(8.dp),
                        onLogin = {
                            username, password ->
                            Log.v("MainActivity", "onLogin called $username $password")
                        }
                    )
                    }
                }
            }
        }
    }

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onPress: () -> Unit) {
    Column{
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        ElevatedButton(onClick = { onPress() }) {
            Text(text = "Press Me")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PaparaworkshopTheme {
        Greeting("Android")
    }
}*/