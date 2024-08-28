package com.mindera.rocketscience.data.mapper

import com.mindera.rocketscience.data.model.launch.LaunchModel
import com.mindera.rocketscience.domain.dto.LaunchDto

fun LaunchModel.toDomain() =
    LaunchDto(
        missionName,
        launchDateUnix.toLong() * 1000,
        rocket.rocketName,
        rocket.rocketType,
        links.missionPatchSmall ?: "",
        launchSuccess,
        links.toDomain()
    )

fun List<LaunchModel>.toDomain() = map { it.toDomain() }