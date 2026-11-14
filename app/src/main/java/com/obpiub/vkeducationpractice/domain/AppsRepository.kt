package com.obpiub.vkeducationpractice.domain


interface AppsRepository {
    suspend fun getApp(id: String): App
    suspend fun getCatalog(): List<CatalogApp>
}