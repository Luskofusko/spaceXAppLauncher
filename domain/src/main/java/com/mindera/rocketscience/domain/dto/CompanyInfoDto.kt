package com.mindera.rocketscience.domain.dto

data class CompanyInfoDto(
    val companyName: String,
    val founderName: String,
    val year: Int,
    val employees: Long,
    val launchSites: Long,
    val valuation: Long
)
