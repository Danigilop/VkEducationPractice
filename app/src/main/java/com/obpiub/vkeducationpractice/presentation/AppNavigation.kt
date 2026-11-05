package com.obpiub.vkeducationpractice.presentation

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    onToolBarClick:() -> Unit
){
    val navController = rememberNavController()
    NavHost(
        modifier= modifier,
        navController = navController,
        startDestination = "list",
    ){
        composable("list"){
            val appListViewModel: AppListViewModel = hiltViewModel()
            Column() {
                AppToolbar(
                    onToolBarClick = onToolBarClick
                )
                Spacer(Modifier.height(16.dp))
                AppList(
                    appListViewModel.appList,
                    onAppClick = { app ->
                        navController.navigate("details/${app.id}")
                    })
            }
        }
        composable("details/{appId}") {
            val detailsViewModel: AppDetailsViewModel = hiltViewModel()

            AppDetailsScreen(
                state = detailsViewModel.state,
                onBackClick = {
                    navController.popBackStack()
                },
                onAppClick = { app ->
                    navController.navigate("details/${app.id}")
                },
                onShareClick = {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Посмотри это приложение!"
                    )

                    val chooser = Intent.createChooser(
                        intent,
                        "Поделиться с помощью"
                    )

                    navController.context.startActivity(chooser)
                }
            )
            }
        }


    }