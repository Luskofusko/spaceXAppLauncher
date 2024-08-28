package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class RocketModel(
    @JsonProperty("rocket_id") var rocketId: String?,
    @JsonProperty("rocket_name") var rocketName: String,
    @JsonProperty("rocket_type") var rocketType: String,
    @JsonProperty("first_stage") var firstStage: FirstStageModel?,
    @JsonProperty("second_stage") var secondStage: SecondStageModel?,
    @JsonProperty("fairings") var fairings: FairingsModel?
 )
