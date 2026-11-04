package com.obpiub.vkeducationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.obpiub.vkeducationpractice.presentation.AppNavigation
import com.obpiub.vkeducationpractice.ui.theme.VkEducationPracticeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationPracticeTheme {
                val snackbarHostState = remember { (SnackbarHostState()) }
                val scope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }

                ) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier
                            .padding(innerPadding),
                        onToolBarClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Нажали")
                            }
                        }

                    )
                    }
                }
        }
    }
}
