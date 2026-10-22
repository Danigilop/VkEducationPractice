package com.obpiub.vkeducationpractice

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AppRow(
    app: AppItem,
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
        Image(
            painter = painterResource(app.iconRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Column(){
            Text(text = app.name,  color = MaterialTheme.colorScheme.onSurface)
            Text(text = app.description,color = MaterialTheme.colorScheme.onSurface)
            Text(text = app.category,color = MaterialTheme.colorScheme.onSurface)
    }

    }
}
