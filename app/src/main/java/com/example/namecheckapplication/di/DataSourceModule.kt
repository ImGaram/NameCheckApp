package com.example.namecheckapplication.di

import com.example.data.remote.api.LoveCalculatorApi
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.repository.remote.datasource.SplashDataSource
import com.example.data.repository.remote.datasourceimpl.MainDataSourceImpl
import com.example.data.repository.remote.datasourceimpl.SplashDataSourceImpl
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
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

    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseRtdb: FirebaseDatabase,
        fireStore: FirebaseFirestore
    ): SplashDataSource {
        return SplashDataSourceImpl(firebaseRtdb, fireStore)
    }
}