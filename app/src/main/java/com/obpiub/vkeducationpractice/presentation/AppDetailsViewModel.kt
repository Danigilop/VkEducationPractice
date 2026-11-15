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
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    repository: AppsRepository,
    savedStateHandle: SavedStateHandle,

) : ViewModel() {
    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()
    private var installJob: Job? = null
    private val appId: String = checkNotNull(savedStateHandle["appId"])


    init {
        viewModelScope.launch {

            val app = try {
                repository.getApp(appId)
            } catch (e: IOException) {
                _state.value = AppDetailsState.Error("Не удалось загрузить приложение")
                return@launch
            } catch (e: HttpException) {
                _state.value = if (e.code() == 404) AppDetailsState.NotFound("Приложение не найдено")
                else AppDetailsState.Error("Ошибка сервера: ${e.code()}")
                return@launch
            }
            val content = AppDetailsState.Content(app, emptyList())
            _state.value = content
            try {
                val pages = repository.getCatalog().filter { it.id != appId }.chunked(3)
                _state.value = content.copy(showcasePages = pages)
            } catch (e: IOException) {
            } catch (e: HttpException) {
            }
        }
    }
    private fun updateInstallState(installState: InstallState) {
        _state.update { current ->
            if (current is AppDetailsState.Content) {
                current.copy(installState = installState)
            } else {
                current
            }
        }
    }
    fun onInstallClick() {
        val current = _state.value
        if (current !is AppDetailsState.Content) return

        when (current.installState) {
            InstallState.NotInstalled -> {
                updateInstallState(InstallState.Installing(0))
                installJob = viewModelScope.launch {
                    emulateInstall()
                }
            }

            is InstallState.Installing -> {
                installJob?.cancel()
                installJob = null
                updateInstallState(InstallState.NotInstalled)
            }

            InstallState.Installed -> Unit
        }
    }
    private suspend fun emulateInstall(){
        for (progress in 5..100 step 5){
            delay(150)
            updateInstallState(InstallState.Installing(progress))
        }
        updateInstallState(InstallState.Installed)

    }
}