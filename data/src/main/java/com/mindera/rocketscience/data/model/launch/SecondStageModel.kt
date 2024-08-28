package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class SecondStageModel(
    @JsonProperty("block") var block: Int,
    @JsonProperty("payloads") var payloads: ArrayList<PayloadsModel>
)
