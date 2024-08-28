package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class LaunchModel(
    @JsonProperty("flight_number") var flightNumber: Long,
    @JsonProperty("mission_name") var missionName: String,
    @JsonProperty("mission_id") var missionId: ArrayList<String>?,
    @JsonProperty("upcoming") var upcoming: Boolean?,
    @JsonProperty("launch_year") var launchYear: String?,
    @JsonProperty("launch_date_unix") var launchDateUnix: Int,
    @JsonProperty("launch_date_utc") var launchDateUtc: String?,
    @JsonProperty("launch_date_local") var launchDateLocal: String?,
    @JsonProperty("is_tentative") var isTentative: Boolean?,
    @JsonProperty("tentative_max_precision") var tentativeMaxPrecision: String?,
    @JsonProperty("tbd") var tbd: Boolean?,
    @JsonProperty("launch_window") var launchWindow: Int?,
    @JsonProperty("rocket") var rocket: RocketModel,
    @JsonProperty("ships") var ships: ArrayList<String>?,
    @JsonProperty("telemetry") var telemetry: TelemetryModel?,
    @JsonProperty("launch_site") var launchSite: LaunchSiteModel?,
    @JsonProperty("launch_success") var launchSuccess: Boolean,
    @JsonProperty("launch_failure_details") var launchFailureDetails: LaunchFailureDetailsModel?,
    @JsonProperty("links") var links: LinksModel,
    @JsonProperty("details") var details: String,
    @JsonProperty("static_fire_date_utc") var staticFireDateUtc: String?,
    @JsonProperty("static_fire_date_unix") var staticFireDateUnix: Int?,
    @JsonProperty("timeline") var timeline: TimelineModel?
)
