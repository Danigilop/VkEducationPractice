package com.obpiub.vkeducationpractice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.obpiub.vkeducationpractice.ui.theme.VkEducationPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VkEducationPracticeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var text by rememberSaveable { mutableStateOf("") }
    var showError by rememberSaveable { mutableStateOf(false) }


    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                showError=false
            },
            label = {
                Text("Введите текст или номер телефона")
            },
            isError = showError,
            supportingText = {
                if (showError) {
                    Text("Введите текст")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Button( onClick ={
            showError= text.isBlank()
            if(!showError){
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("message", text)
                context.startActivity(intent)
            }
        },
            modifier=Modifier.fillMaxWidth()
        ){
            Text("Открыть вторую Activity")
        }
        Button(
            onClick = {
                val phoneUri = Uri.fromParts("tel", text, null)
                val dialIntent = Intent(Intent.ACTION_DIAL, phoneUri)
                context.startActivity(dialIntent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Позвонить другу")
        }
        Button(
            onClick = {
                showError = text.isBlank()
                if (!showError) {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, text)
                    val chooser = Intent.createChooser(shareIntent, "Поделиться с помощью")
                    context.startActivity(chooser)

                }
                      },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Поделиться")
            }
    }
}