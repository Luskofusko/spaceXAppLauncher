package com.mindera.rocketscience.mapper

import com.mindera.rocketscience.domain.dto.CompanyInfoDto
import com.mindera.rocketscience.model.CompanyInfoModel
import java.text.NumberFormat

fun CompanyInfoDto.toPresentation() = CompanyInfoModel(
    companyName,
    founderName,
    year,
    employees,
    launchSites,
    NumberFormat.getIntegerInstance().format(valuation)
)