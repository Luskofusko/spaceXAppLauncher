package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.domain.dto.CompanyInfoDto

interface GetCompanyInfoUseCase {
    suspend fun getCompanyInfo(): CompanyInfoDto
}