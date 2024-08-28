package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class FirstStageModel(
    @JsonProperty("cores") var cores: ArrayList<CoresModel>
)
