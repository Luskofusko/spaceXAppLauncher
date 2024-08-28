package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.domain.dto.CompanyInfoDto
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository

class GetCompanyInfoUseCaseImpl(private val companyInfoRepository: CompanyInfoRepository): GetCompanyInfoUseCase  {
    override suspend fun getCompanyInfo(): CompanyInfoDto {
        return companyInfoRepository.getCompanyInfo()
    }

}