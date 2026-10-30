package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.obpiub.vkeducationpractice.data.AppMapper
import com.obpiub.vkeducationpractice.data.AppsRepositoryImpl

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
            val appListViewModel: AppListViewModel = viewModel(factory = viewModelFactory {
                initializer {
                    val mapper = AppMapper()
                    val repository = AppsRepositoryImpl(mapper)
                    AppListViewModel(repository)
                }
            }
            )
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
        composable("details/{appId}") {backStackEntry ->
            val appId = requireNotNull(
                backStackEntry.arguments?.getString("appId")
            )
            val detailsViewModel: AppDetailsViewModel = viewModel(
                factory = viewModelFactory {
                    initializer {
                        val mapper = AppMapper()
                        val repository = AppsRepositoryImpl(mapper)
                        AppDetailsViewModel(
                            repository,
                            appId=appId)
                    }
                }
            )

            AppDetailsScreen(
                state = detailsViewModel.state,
                onBackClick = {
                    navController.popBackStack()
                },
                onAppClick = { app ->
                    navController.navigate("details/${app.id}")
                }
            )
            }
        }


    }