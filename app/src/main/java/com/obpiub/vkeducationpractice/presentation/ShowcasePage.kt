package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.obpiub.vkeducationpractice.domain.App

@Composable
fun ShowcasePage(
    apps: List<App>,
    modifier: Modifier = Modifier,
    onAppClick: (App) -> Unit
){
    Column(modifier = modifier) {
        apps.forEach { app->
            AppRow(app,
                onCLick ={
                    onAppClick(app)
                } )
        }
    }

}