package com.obpiub.vkeducationpractice.presentation

import com.obpiub.vkeducationpractice.domain.App

sealed interface AppDetailsState {
    data class Content(
        val app: App,
        val showcasePages: List<List<App>>
    ) : AppDetailsState

    data object NotFound : AppDetailsState
}