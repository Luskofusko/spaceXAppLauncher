package com.mindera.rocketscience.domain.repository

import com.mindera.rocketscience.domain.dto.CompanyInfoDto

interface CompanyInfoRepository {
    suspend fun getCompanyInfo(): CompanyInfoDto
}