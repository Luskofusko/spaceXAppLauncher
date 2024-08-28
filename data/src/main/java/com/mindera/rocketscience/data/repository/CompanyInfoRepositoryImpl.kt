package com.mindera.rocketscience.data.repository

import com.mindera.rocketscience.data.api.SpaceXApi
import com.mindera.rocketscience.data.mapper.toDomain
import com.mindera.rocketscience.domain.dto.CompanyInfoDto
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository

class CompanyInfoRepositoryImpl(private val spaceXApi: SpaceXApi) : CompanyInfoRepository {
    override suspend fun getCompanyInfo(): CompanyInfoDto {
        return spaceXApi.getCompanyInfo().toDomain()
    }

}