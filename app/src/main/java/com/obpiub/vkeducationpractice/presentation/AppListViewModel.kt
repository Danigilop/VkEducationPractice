package com.obpiub.vkeducationpractice.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obpiub.vkeducationpractice.domain.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: AppsRepository,
): ViewModel(){
    var state: AppListState by mutableStateOf(AppListState.Loading)
        private set
    val appList = repository.getApps()
    init {
        loadCatalog()
    }
    private fun loadCatalog(){
        viewModelScope.launch {
            try {
                val apps = repository.getCatalog()
                state = AppListState.Content(apps)
            }
            catch (e: IOException){
                Log.e("CatalogLoad", "Ошибка загрузки каталога", e)
                state = AppListState.Error("Не удалось загрузить каталог")
            }
            catch (e: HttpException){
                Log.e("CatalogLoad", "Ошибка загрузки каталога", e)
                state= AppListState.Error("Не удалось загрузить каталог")
            }
        }
    }
}