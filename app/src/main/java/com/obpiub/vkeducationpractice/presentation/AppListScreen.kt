package com.obpiub.vkeducationpractice.presentation



import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.obpiub.vkeducationpractice.domain.CatalogApp

@Composable
fun AppListScreen(state: AppListState,
                  onAppClick:(String) -> Unit){
    when(state) {
        is AppListState.Loading  -> {
            CircularProgressIndicator()
        }
        is AppListState.Error -> {
            Text(state.message)
        }
        is AppListState.Content -> {
            LazyColumn() {
                items(state.apps){app ->
                    CatalogAppRow(
                        app = app,
                        rating = state.ratings[app.id],
                        onClick = {
                            onAppClick(app.id)
                        })
                }
                }
            }
        }
    }