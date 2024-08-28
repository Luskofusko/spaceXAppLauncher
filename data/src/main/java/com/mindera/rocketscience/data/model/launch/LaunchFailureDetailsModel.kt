package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class LaunchFailureDetailsModel(
    @JsonProperty("time") var time: Int,
    @JsonProperty("altitude") var altitude: String?,
    @JsonProperty("reason") var reason: String
)
