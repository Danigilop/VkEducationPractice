package com.obpiub.vkeducationpractice.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.obpiub.vkeducationpractice.R

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    onToolBarClick:()-> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
            .clickable(onClick = onToolBarClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    )
    {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                contentDescription = "Иконка приложения",
                modifier = Modifier.size(40.dp)
            )
        }
}