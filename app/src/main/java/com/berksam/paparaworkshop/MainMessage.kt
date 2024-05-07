package com.berksam.paparaworkshop


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainMessage() {
    var isTimeVisible by remember { mutableStateOf(true) }
    var messageText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf(
        "Hi!",
        "Test1",
        "Test2."
    ) }

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            messages.forEach { message ->
                Card(
                    modifier = Modifier.padding(4.dp).width(150.dp).height(30.dp),
                    onClick = { isTimeVisible = !isTimeVisible }
                ) {
                    Text(modifier = Modifier.padding(4.dp),text = message, color = Color.Black)
                }
            }
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                // Message text box
                TextField(
                    value = messageText,
                    onValueChange = { messageText = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Send
                    ),
                    keyboardActions = KeyboardActions(onSend = {
                        if (messageText.isNotBlank()) {
                            messages.add(messageText)
                            messageText = ""
                        }
                    }),
                    modifier = Modifier.weight(1f).clip(RoundedCornerShape(16.dp))
                )
                ElevatedButton(
                    onClick = {
                        if (messageText.isNotBlank()) {
                            messages.add(messageText)
                            messageText = ""
                        }
                    }
                ) {
                    Text(text = "Send")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainMessage(){
    MainMessage()
}