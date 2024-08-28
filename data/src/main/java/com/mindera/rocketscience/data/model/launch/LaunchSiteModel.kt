package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class LaunchSiteModel(
    @JsonProperty("site_id") var siteId: String,
    @JsonProperty("site_name") var siteName: String,
    @JsonProperty("site_name_long") var siteNameLong: String
)
