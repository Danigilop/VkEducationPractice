package com.obpiub.vkeducationpractice.presentation

import com.obpiub.vkeducationpractice.domain.App
import com.obpiub.vkeducationpractice.domain.CatalogApp

sealed interface AppDetailsState {
    data class Content(
        val app: App,
        val showcasePages: List<List<CatalogApp>>
    ) : AppDetailsState

    data class NotFound(
        val message: String
    ) : AppDetailsState
    data object Loading: AppDetailsState
    data class Error(
        val message: String
    ): AppDetailsState
}