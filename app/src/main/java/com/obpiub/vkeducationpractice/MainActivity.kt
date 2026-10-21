package com.obpiub.vkeducationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.obpiub.vkeducationpractice.ui.theme.VkEducationPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationPracticeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppToolbar()
                    }
                ) { innerPadding ->
                    AppShowcase(pages = showcasePages,
                        onAppClick ={selectedApp ->
                            println(selectedApp.name)
                        },
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize())
                    //AppList(
                      //  apps = apps,
                        //onAppClick = {selectedApp ->
                          //  println(selectedApp.name)

                        //},
                        //modifier = Modifier
                          //  .padding(innerPadding)
                            //.fillMaxSize()
                    //)
                    }
                }
        }
    }
}
