package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class FairingsModel(
    @JsonProperty("reused") var reused: Boolean,
    @JsonProperty("recovery_attempt") var recoveryAttempt: Boolean,
    @JsonProperty("recovered") var recovered: Boolean,
    @JsonProperty("ship") var ship: String?
)
