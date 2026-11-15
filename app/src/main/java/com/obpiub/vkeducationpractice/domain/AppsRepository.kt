package com.obpiub.vkeducationpractice.domain


interface AppsRepository {
    suspend fun getApp(id: String): App
    suspend fun getCatalog(): List<CatalogApp>
    suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float>
    suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float>
}