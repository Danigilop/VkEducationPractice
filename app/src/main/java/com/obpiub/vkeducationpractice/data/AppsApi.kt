package com.obpiub.vkeducationpractice.data

import retrofit2.http.GET
import retrofit2.http.Path


interface AppsApi{
    @GET("catalog")
    suspend fun getCatalogApp(): List<CatalogAppDto>
    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}