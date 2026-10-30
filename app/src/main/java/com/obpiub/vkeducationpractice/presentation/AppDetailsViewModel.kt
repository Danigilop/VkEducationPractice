package com.obpiub.vkeducationpractice.presentation

import androidx.lifecycle.ViewModel
import com.obpiub.vkeducationpractice.domain.AppsRepository

class AppDetailsViewModel(
    private val repository: AppsRepository,
    private val appId: String
) : ViewModel() {
    val state: AppDetailsState

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