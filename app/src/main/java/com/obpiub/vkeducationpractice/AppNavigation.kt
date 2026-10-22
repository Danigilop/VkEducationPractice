package com.obpiub.vkeducationpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
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
            val appListViewModel: AppListViewModel = viewModel()
            Column() {
                AppToolbar(
                    onToolBarClick = onToolBarClick)
                Spacer(Modifier.height(16.dp))
                    AppList(appListViewModel.appList,
                        onAppClick = {
                            navController.navigate("details")
                        })
            }
        }
        composable("details") {
            AppDetailsScreen(onBackClick = {
                navController.popBackStack()
            })
        }


    }
}