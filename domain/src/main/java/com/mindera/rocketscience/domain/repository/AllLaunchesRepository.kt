package com.mindera.rocketscience.domain.repository

import com.mindera.rocketscience.domain.dto.LaunchDto
import kotlinx.coroutines.flow.Flow


interface AllLaunchesRepository {

    fun allLaunches(): Flow<List<LaunchDto>>

}