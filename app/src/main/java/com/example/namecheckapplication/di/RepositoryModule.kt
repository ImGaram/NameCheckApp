package com.example.namecheckapplication.di

import com.example.data.repository.MainRepositoryImpl
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.repository.remote.datasourceimpl.MainDataSourceImpl
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(mainDataSource: MainDataSource): MainRepository {
        return MainRepositoryImpl(mainDataSource)
    }
}