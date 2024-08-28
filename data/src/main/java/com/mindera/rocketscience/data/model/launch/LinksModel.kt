package com.mindera.rocketscience.data.model.launch

import com.fasterxml.jackson.annotation.JsonProperty

data class LinksModel(
    @JsonProperty("mission_patch") var missionPatch: String?,
    @JsonProperty("mission_patch_small") var missionPatchSmall: String?,
    @JsonProperty("reddit_campaign") var redditCampaign: String?,
    @JsonProperty("reddit_launch") var redditLaunch: String?,
    @JsonProperty("reddit_recovery") var redditRecovery: String?,
    @JsonProperty("reddit_media") var redditMedia: String?,
    @JsonProperty("presskit") var presskit: String?,
    @JsonProperty("article_link") var articleLink: String?,
    @JsonProperty("wikipedia") var wikipedia: String?,
    @JsonProperty("video_link") var videoLink: String?,
    @JsonProperty("youtube_id") var youtubeId: String?,
    @JsonProperty("flickr_images") var flickrImages: ArrayList<String>?


)
