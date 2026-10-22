package com.obpiub.vkeducationpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
){
    val navController = rememberNavController()
    NavHost(
        modifier= modifier,
        navController = navController,
        startDestination = "list",
    ){
        composable("list"){
            Column() {
                AppToolbar()
                Spacer(Modifier.height(16.dp))
                    AppList(apps,
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