package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class TimelineModel(
    @JsonProperty("webcast_liftoff") var webcastLiftoff: Int?
)
