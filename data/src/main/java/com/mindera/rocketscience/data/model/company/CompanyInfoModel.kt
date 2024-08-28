package com.mindera.rocketscience.data.model.company

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyInfoModel(
    @JsonProperty("name") var name: String,
    @JsonProperty("founder") var founder: String,
    @JsonProperty("founded") var founded: Int,
    @JsonProperty("employees") var employees: Long,
    @JsonProperty("vehicles") var vehicles: Long,
    @JsonProperty("launch_sites") var launchSites: Long,
    @JsonProperty("test_sites") var testSites: Long,
    @JsonProperty("ceo") var ceo: String,
    @JsonProperty("cto") var cto: String,
    @JsonProperty("coo") var coo: String,
    @JsonProperty("cto_propulsion") var ctoPropulsion: String,
    @JsonProperty("valuation") var valuation: Long,
    @JsonProperty("headquarters") var headquarters: HeadquartersModel,
    @JsonProperty("links") var links: LinksModel,
    @JsonProperty("summary") var summary: String
)
