package com.example.domain.usecase

import com.example.domain.repository.MainRepository
import javax.inject.Inject

class SetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute(plusValue: Int) = mainRepository.setStatistics(plusValue)
}