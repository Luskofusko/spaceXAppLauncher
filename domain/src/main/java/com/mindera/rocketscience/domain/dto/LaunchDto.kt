package com.mindera.rocketscience.domain.dto

data class LaunchDto(
    val missionName: String,
    val launchTimestamp: Long,
    val rocketName: String,
    val rocketType: String,
    val missionPatchImageUrl: String,
    val launchSuccessful: Boolean,
    val links: LinksDto
)
