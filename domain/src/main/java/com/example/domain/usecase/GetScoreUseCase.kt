package com.example.domain.usecase

import com.example.domain.repository.MainRepository
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val mainRepository: MainRepository
){
    fun execute() = mainRepository.getScore()
}