package com.obpiub.vkeducationpractice.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obpiub.vkeducationpractice.domain.App
import com.obpiub.vkeducationpractice.domain.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    repository: AppsRepository,
    savedStateHandle: SavedStateHandle,

) : ViewModel() {
    var state: AppDetailsState by mutableStateOf(AppDetailsState.Loading)
        private set
    private val appId: String = checkNotNull(savedStateHandle["appId"])


    init {
        viewModelScope.launch {

            val app = try {
                repository.getApp(appId)
            } catch (e: IOException) {
                state = AppDetailsState.Error("Не удалось загрузить приложение")
                return@launch
            } catch (e: HttpException) {
                state = if (e.code() == 404) AppDetailsState.NotFound("Приложение не найдено")
                else AppDetailsState.Error("Ошибка сервера: ${e.code()}")
                return@launch
            }
            val content = AppDetailsState.Content(app, emptyList())
            state = content
            try {
                val pages = repository.getCatalog().filter { it.id != appId }.chunked(3)
                state = content.copy(showcasePages = pages)
            } catch (e: IOException) {
                // Keep successfully loaded details.
            } catch (e: HttpException) {
                // Keep successfully loaded details.
            }
        }
    }
}