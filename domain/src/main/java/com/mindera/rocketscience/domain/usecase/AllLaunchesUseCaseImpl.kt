package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.domain.dto.LaunchDto
import com.mindera.rocketscience.domain.repository.AllLaunchesRepository
import kotlinx.coroutines.flow.Flow

class AllLaunchesUseCaseImpl(private val allLaunchesRepository: AllLaunchesRepository) : AllLaunchesUseCase {
    override fun allLaunches(): Flow<List<LaunchDto>> {
        return allLaunchesRepository.allLaunches()
    }
}
