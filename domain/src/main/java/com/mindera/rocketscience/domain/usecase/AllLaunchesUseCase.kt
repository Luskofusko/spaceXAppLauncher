package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.domain.dto.LaunchDto
import kotlinx.coroutines.flow.Flow

interface AllLaunchesUseCase {
    fun allLaunches(): Flow<List<LaunchDto>>
}