package com.obpiub.vkeducationpractice.domain

interface AppsRepository {
    fun getApps(): List<App>
    suspend fun getCatalog(): List<CatalogApp>
}