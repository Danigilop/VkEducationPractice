package com.obpiub.vkeducationpractice.domain

interface AppsRepository {
    fun getApps(): List<App>
}