package com.obpiub.vkeducationpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShowcasePage(
    apps: List<AppItem>,
    modifier: Modifier = Modifier,
    onAppClick: (AppItem) -> Unit
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