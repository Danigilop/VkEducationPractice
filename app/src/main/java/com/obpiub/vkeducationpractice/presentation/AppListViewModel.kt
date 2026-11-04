package com.obpiub.vkeducationpractice.presentation

import androidx.lifecycle.ViewModel
import com.obpiub.vkeducationpractice.domain.AppsRepository

class AppListViewModel(
    private val repository: AppsRepository,
): ViewModel(){
    val appList = repository.getApps()
}