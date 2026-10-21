package com.obpiub.vkeducationpractice

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun AppList(
    apps: List<AppItem>,
    modifier: Modifier = Modifier,
    onAppClick: (AppItem) -> Unit
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