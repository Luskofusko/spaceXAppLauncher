package com.mindera.rocketscience.mapper

import com.mindera.rocketscience.domain.dto.LinksDto
import com.mindera.rocketscience.model.LinksModel

fun LinksDto.toPresentation() = LinksModel(
    articles,
    wikipedia,
    videoPages
)