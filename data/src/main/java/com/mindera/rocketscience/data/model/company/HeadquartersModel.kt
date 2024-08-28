package com.mindera.rocketscience.data.model.company

import com.fasterxml.jackson.annotation.JsonProperty

data class HeadquartersModel(
    @JsonProperty("address") var address: String,
    @JsonProperty("city") var city: String,
    @JsonProperty("state") var state: String
)
