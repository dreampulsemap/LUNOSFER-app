package io.lunosfer.dreamap.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Message(
    val id: String,
    @Json(name = "sender_id") val senderId: String,
    @Json(name = "recipient_id") val recipientId: String,
    val content: String? = null,
    @Json(name = "is_read") val isRead: Boolean = false,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "attachment_url") val attachmentUrl: String? = null,
    @Json(name = "attachment_type") val attachmentType: String? = null,
    @Json(name = "attachment_name") val attachmentName: String? = null
)

/** pages/api/messages/conversations.js: her satır bir kişiyle olan son durumu özetler. */
@JsonClass(generateAdapter = true)
data class Conversation(
    val otherUser: UserProfile,
    val lastMessage: Message,
    val unreadCount: Int
)

@JsonClass(generateAdapter = true)
data class ConversationsResponse(
    val conversations: List<Conversation>
)

@JsonClass(generateAdapter = true)
data class ThreadResponse(
    val messages: List<Message>,
    val otherUser: UserProfile,
    val hasMore: Boolean = false
)

@JsonClass(generateAdapter = true)
data class UnreadCountResponse(
    val unreadCount: Int
)
