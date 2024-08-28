package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class PayloadsModel(
    @JsonProperty("payload_id") var payloadId: String?,
    @JsonProperty("norad_id") var noradId: ArrayList<String>?,
    @JsonProperty("reused") var reused: Boolean?,
    @JsonProperty("customers") var customers: ArrayList<String>?,
    @JsonProperty("nationality") var nationality: String?,
    @JsonProperty("manufacturer") var manufacturer: String?,
    @JsonProperty("payload_type") var payloadType: String?,
    @JsonProperty("payload_mass_kg") var payloadMassKg: Int?,
    @JsonProperty("payload_mass_lbs") var payloadMassLbs: Int?,
    @JsonProperty("orbit") var orbit: String?,
    @JsonProperty("orbit_params") var orbitParams: OrbitParamsModel?
)
