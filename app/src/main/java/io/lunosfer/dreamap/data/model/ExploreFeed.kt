package io.lunosfer.dreamap.data.model

import com.squareup.moshi.JsonClass

/** pages/api/explore/feed.js response şekli. */
@JsonClass(generateAdapter = true)
data class ExploreFeedResponse(
    val dreams: List<Dream>,
    val page: Int,
    val hasMore: Boolean,
    val rankToken: String? = null
)
