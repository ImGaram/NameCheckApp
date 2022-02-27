package com.example.domain.usecase

import com.example.domain.model.DomainScore
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class SetScoreUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute(score: DomainScore) = mainRepository.setScore(score)
}