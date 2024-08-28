package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class TelemetryModel(
    @JsonProperty("flight_club") var flightClub: String?
)
