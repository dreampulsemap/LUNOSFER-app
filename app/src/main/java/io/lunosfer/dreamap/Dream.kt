package io.lunosfer.dreamap.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * dreams tablosu satırı. Alan isimleri pages/api/submit-dream.js (insert payload)
 * ve pages/api/home-feed.js / explore/feed.js (select + owner attach) ile eşleşir.
 * Web tarafında henüz kullanılmayan/gösterilmeyen sütunlar (ör. latitude,
 * map_detail) buraya alınmadı — sadece kart render için gerekenler.
 */
@JsonClass(generateAdapter = true)
data class Dream(
    val id: String,
    @Json(name = "user_id") val userId: String,
    val content: String,
    @Json(name = "ai_title") val aiTitle: String? = null,
    @Json(name = "ai_image_url") val aiImageUrl: String? = null,
    @Json(name = "ai_archetypes") val aiArchetypes: List<String>? = null,
    @Json(name = "image_status") val imageStatus: String? = null,
    @Json(name = "user_selected_sentiment") val userSelectedSentiment: String? = null,
    @Json(name = "dream_date") val dreamDate: String? = null,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "likes_count") val likesCount: Int? = 0,
    @Json(name = "comments_count") val commentsCount: Int? = 0,
    val visibility: String? = null,
    // home-feed.js JOIN sonucunda ekleniyor; explore/feed.js'de de owner attachOwners() ile geliyor.
    val owner: UserProfile? = null,
    // home-feed.js her item'a feed_type: 'dream' | 'vision' ekliyor, tek listede ayırt etmek için.
    @Json(name = "feed_type") val feedType: String? = "dream"
) {
    val displayTitle: String get() = aiTitle?.takeIf { it.isNotBlank() } ?: content.take(60)
}
