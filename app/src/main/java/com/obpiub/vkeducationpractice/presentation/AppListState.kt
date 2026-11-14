package com.obpiub.vkeducationpractice.presentation

import com.obpiub.vkeducationpractice.domain.CatalogApp

sealed interface AppListState {
    data object Loading: AppListState
    data class Error(
        val message: String
    ): AppListState
    data class Content(
        val apps: List<CatalogApp>

    ): AppListState
}