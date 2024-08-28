package com.mindera.rocketscience.data.mapper

import com.mindera.rocketscience.data.model.company.CompanyInfoModel
import com.mindera.rocketscience.domain.dto.CompanyInfoDto

fun CompanyInfoModel.toDomain() =
    CompanyInfoDto(name, founder, founded, employees, launchSites, valuation)