package com.obpiub.vkeducationpractice.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.obpiub.vkeducationpractice.domain.CatalogApp

@Composable
fun CatalogAppRow(app: CatalogApp){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = app.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp)),
            onError = { error ->
                Log.e(
                    "CatalogIcon",
                    "URL: ${app.iconUrl}; ошибка: ${error.result.throwable}"
                )
            },

            )
        Spacer(Modifier.width(12.dp))
        Column() {
            Text(app.name)
            Text(app.description)
            Text(app.category)
        }

    }
}