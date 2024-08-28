package com.mindera.rocketscience.data.repository

import com.mindera.rocketscience.data.api.SpaceXApi
import com.mindera.rocketscience.data.mapper.toDomain
import com.mindera.rocketscience.domain.dto.LaunchDto
import com.mindera.rocketscience.domain.repository.AllLaunchesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AllLaunchesRepositoryImpl(private val spaceXApi: SpaceXApi): AllLaunchesRepository {
    override fun allLaunches(): Flow<List<LaunchDto>> {
        return spaceXApi.allLaunches().map {
            it.toDomain()
        }
    }
}