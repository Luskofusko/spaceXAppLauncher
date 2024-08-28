package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class OrbitParamsModel(
    @JsonProperty("reference_system") var referenceSystem: String?,
    @JsonProperty("regime") var regime: String?,
    @JsonProperty("longitude") var longitude: String?,
    @JsonProperty("semi_major_axis_km") var semiMajorAxisKm: String?,
    @JsonProperty("eccentricity") var eccentricity: String?,
    @JsonProperty("periapsis_km") var periapsisKm: Int?,
    @JsonProperty("apoapsis_km") var apoapsisKm: Int?,
    @JsonProperty("inclination_deg") var inclinationDeg: Int?,
    @JsonProperty("period_min") var periodMin: String?,
    @JsonProperty("lifespan_years") var lifespanYears: String?,
    @JsonProperty("epoch") var epoch: String?,
    @JsonProperty("mean_motion") var meanMotion: String?,
    @JsonProperty("raan") var raan: String?,
    @JsonProperty("arg_of_pericenter") var argOfPericenter: String?,
    @JsonProperty("mean_anomaly") var meanAnomaly: String?
)
