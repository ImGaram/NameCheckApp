package com.example.domain.usecase

import com.example.domain.repository.SplashRepository
import javax.inject.Inject

class CheckAppVersionUseCase @Inject constructor(
    private val splashRepository: SplashRepository
){
    fun execute() = splashRepository.checkAppVersion()
}