package com.obpiub.vkeducationpractice.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.obpiub.vkeducationpractice.domain.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    repository: AppsRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val state: AppDetailsState
    private val appId: String = checkNotNull(savedStateHandle["appId"])

    init {
        val apps = repository.getApps()
        val app = apps.firstOrNull{ app ->
            app.id == appId
        }

        state = if (app != null) {
            AppDetailsState.Content(
                app = app,
                showcasePages = apps.chunked(3)
            )
        } else {
            AppDetailsState.NotFound
        }
    }
}