package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.obpiub.vkeducationpractice.domain.App
import com.obpiub.vkeducationpractice.domain.Category

@Composable
fun AppRow(
    app: App,
    modifier: Modifier = Modifier,
    onCLick: () -> Unit
    ){
    Row(modifier = modifier
        .fillMaxWidth()
        .clickable(onClick =onCLick)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
        AsyncImage(
            model = app.iconUrl,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Column(){
            Text(text = app.name,  color = MaterialTheme.colorScheme.onSurface)
            Text(text = app.description,color = MaterialTheme.colorScheme.onSurface, maxLines = 2, overflow = TextOverflow.Ellipsis)
            Text(
                text = when (app.category) {
                    Category.APP -> "Приложение"
                    Category.GAME -> "Игра"
                },
                color = MaterialTheme.colorScheme.onSurface
            )
    }

    }
}
