package com.obpiub.vkeducationpractice.presentation

sealed interface InstallState {
    data object NotInstalled: InstallState
    data class Installing(
        val progress: Int
    ): InstallState
    data object Installed: InstallState

}