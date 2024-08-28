package com.mindera.rocketscience.model

data class LaunchModel(
    val missionName: String,
    val launchTimestamp: Long,
    val date: String,
    val time: String,
    val rocketName: String,
    val rocketType: String,
    val missionPatchImageUrl: String,
    val launchSuccess: Boolean,
    val days: Long,
    val linksModel: LinksModel,
    val id: Int

)
