package com.obpiub.vkeducationpractice.presentation

import androidx.lifecycle.ViewModel
import com.obpiub.vkeducationpractice.domain.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    repository: AppsRepository,
): ViewModel(){
    val appList = repository.getApps()
}