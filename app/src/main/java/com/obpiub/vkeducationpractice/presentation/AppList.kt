package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.obpiub.vkeducationpractice.domain.App


@Composable
fun AppList(
    apps: List<App>,
    modifier: Modifier = Modifier,
    onAppClick: (App) -> Unit
){
    LazyColumn(
        modifier = modifier){
        items(apps){app ->
            AppRow(app = app,
                onCLick = {
                    onAppClick(app)
                }
            )

        }
    }

    }