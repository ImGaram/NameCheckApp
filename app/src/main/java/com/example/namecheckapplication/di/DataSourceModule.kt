package com.example.namecheckapplication.di

import com.example.data.remote.api.LoveCalculatorApi
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.repository.remote.datasourceimpl.MainDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideMainDataSource(loveCalculatorApi: LoveCalculatorApi): MainDataSource {
        return MainDataSourceImpl(loveCalculatorApi)
    }
}