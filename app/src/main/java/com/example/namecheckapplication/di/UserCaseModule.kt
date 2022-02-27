package com.example.namecheckapplication.di

import com.example.domain.repository.MainRepository
import com.example.domain.repository.SplashRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserCaseModule {
    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository: MainRepository) = CheckLoveCalculatorUseCase(repository)

    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository: SplashRepository) = CheckAppVersionUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStatisticsUseCase(repository: MainRepository) = GetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetStatisticsUseCase(repository: MainRepository) = SetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetScoreUseCase(repository: MainRepository) = SetScoreUseCase(repository)

    @Provides
    @Singleton
    fun provideGetScoreUseCase(repository: MainRepository) = GetScoreUseCase(repository)
}
