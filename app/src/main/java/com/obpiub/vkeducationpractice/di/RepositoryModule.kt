package com.obpiub.vkeducationpractice.di

import com.obpiub.vkeducationpractice.data.AppsRepositoryImpl
import com.obpiub.vkeducationpractice.domain.AppsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindAppsRepository(
        appsRepositoryImpl: AppsRepositoryImpl
    ): AppsRepository
}