package com.mindera.rocketscience.data.model.company

import com.fasterxml.jackson.annotation.JsonProperty

data class LinksModel(
    @JsonProperty("elon_twitter") var elonTwitter: String,
    @JsonProperty("flickr") var flickr: String,
    @JsonProperty("twitter") var twitter: String,
    @JsonProperty("website") var website: String
)
