package com.mindera.rocketscience.data.mapper

import com.mindera.rocketscience.data.model.launch.LinksModel
import com.mindera.rocketscience.domain.dto.LinksDto

fun LinksModel.toDomain() =
    LinksDto(
        articleLink ?: "",
        wikipedia ?: "",
        videoLink ?: ""
    )