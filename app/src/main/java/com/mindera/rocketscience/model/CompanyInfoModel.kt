package com.mindera.rocketscience.model

data class CompanyInfoModel(
    val companyName: String,
    val founderName: String,
    val year: Int,
    val employees: Long,
    val launchSites: Long,
    val valuation: String,
)
