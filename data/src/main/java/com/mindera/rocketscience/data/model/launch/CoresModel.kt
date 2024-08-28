package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class CoresModel(
    @JsonProperty("core_serial") var coreSerial: String?,
    @JsonProperty("flight") var flight: Int?,
    @JsonProperty("block") var block: String?,
    @JsonProperty("gridfins") var gridfins: Boolean?,
    @JsonProperty("legs") var legs: Boolean?,
    @JsonProperty("reused") var reused: Boolean?,
    @JsonProperty("land_success") var landSuccess: String?,
    @JsonProperty("landing_intent") var landingIntent: Boolean?,
    @JsonProperty("landing_type") var landingType: String?,
    @JsonProperty("landing_vehicle") var landingVehicle: String?
)
