package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.obpiub.vkeducationpractice.domain.App
import com.obpiub.vkeducationpractice.domain.CatalogApp

@Composable
fun ShowcasePage(
    apps: List<CatalogApp>,
    modifier: Modifier = Modifier,
    onAppClick: (String) -> Unit
){
    Column(modifier = modifier) {
        apps.forEach { app->
            CatalogAppRow(app,
                onClick ={
                    onAppClick(app.id)
                } )
        }
    }

}