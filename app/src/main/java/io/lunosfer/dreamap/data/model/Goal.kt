package io.lunosfer.dreamap.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * goals tablosu satırı ("Vizyon" = Vision Board hedefi). Alanlar
 * pages/api/goals/create.js (insert payload) ve pages/api/goals/list.js
 * (select + join'ler) ile eşleşir. GoalCard.jsx'te render edilen alanların
 * hepsi burada: title, cover_image_url, status, completion_percentage,
 * believers_count, has_reacted, has_saved, slide_count, owner.
 */
@JsonClass(generateAdapter = true)
data class Goal(
    val id: String,
    @Json(name = "user_id") val userId: String,
    val title: String,
    val description: String? = null,
    @Json(name = "cover_image_url") val coverImageUrl: String? = null,
    @Json(name = "cover_image_source") val coverImageSource: String? = null,
    val status: String = "active",
    val visibility: String = "public",
    @Json(name = "completion_percentage") val completionPercentage: Int? = 0,
    @Json(name = "believers_count") val believersCount: Int? = 0,
    @Json(name = "has_reacted") val hasReacted: Boolean? = false,
    @Json(name = "has_saved") val hasSaved: Boolean? = false,
    @Json(name = "slide_count") val slideCount: Int? = 0,
    @Json(name = "target_date") val targetDate: String? = null,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "micro_goals") val microGoals: List<MicroGoal>? = null,
    val owner: UserProfile? = null,
    @Json(name = "feed_type") val feedType: String? = "vision"
)

@JsonClass(generateAdapter = true)
data class MicroGoal(
    val id: String,
    val title: String,
    @Json(name = "is_completed") val isCompleted: Boolean = false,
    @Json(name = "order_index") val orderIndex: Int? = null
)

@JsonClass(generateAdapter = true)
data class GoalsListResponse(
    val goals: List<Goal>,
    val page: Int,
    val hasMore: Boolean
)
