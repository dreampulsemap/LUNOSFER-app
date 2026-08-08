package io.lunosfer.dreamap.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * user_profiles tablosundan owner/otherUser alanları için ortak model.
 * pages/api/home-feed.js, explore/feed.js, goals/list.js, messages/*.js
 * hepsi bu şekildeki { id, username, display_name, avatar_url } nesnesini döner.
 */
@JsonClass(generateAdapter = true)
data class UserProfile(
    val id: String,
    val username: String? = null,
    @Json(name = "display_name") val displayName: String? = null,
    @Json(name = "avatar_url") val avatarUrl: String? = null
) {
    /** UI'da gösterilecek isim: display_name yoksa username'e, o da yoksa "?"e düşer. */
    val nameOrFallback: String get() = displayName?.takeIf { it.isNotBlank() }
        ?: username?.takeIf { it.isNotBlank() }
        ?: "?"
}
