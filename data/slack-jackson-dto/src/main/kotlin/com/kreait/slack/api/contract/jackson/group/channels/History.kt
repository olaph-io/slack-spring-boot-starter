package com.kreait.slack.api.contract.jackson.group.channels

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.kreait.slack.api.contract.jackson.util.InstantToString
import com.kreait.slack.api.contract.jackson.util.JacksonDataClass
import java.time.Instant

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ok",
        visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(value = SuccessfulChannelsHistoryResponse::class, name = "true"),
        JsonSubTypes.Type(value = ErrorChannelsHistoryResponse::class, name = "false")
)
@JacksonDataClass
sealed class ChannelsHistoryResponse constructor(@JsonProperty("ok") open val ok: Boolean)

@JacksonDataClass
data class SuccessfulChannelsHistoryResponse constructor(override val ok: Boolean,
                                                         @JsonProperty("messages") val messages: List<Message>?,
                                                         @InstantToString @JsonProperty("latest") val latestTimestamp: Instant?,
                                                         @JsonProperty("has_more") val hasMore: Boolean?) : ChannelsHistoryResponse(ok) {

    companion object {}

    data class Message(
            @JsonProperty("attachments") val attachments: List<Attachment?>?,
            @JsonProperty("bot_id") val botId: String?,
            @JsonProperty("is_starred") val isStarred: Boolean = false,
            @JsonProperty("reactions") val reactions: List<Reaction>?,
            @JsonProperty("subtype") val subtype: String?,
            @JsonProperty("text") val text: String?,
            @InstantToString @JsonProperty("ts") val timestamp: Instant?,
            @JsonProperty("type") val type: String?,
            @JsonProperty("user") val user: String?,
            @JsonProperty("username") val username: String?
    ) {
        companion object
    }

    data class Reaction(
            @JsonProperty("count") val count: Int?,
            @JsonProperty("name") val name: String?,
            @JsonProperty("users") val users: List<String>?
    ) {
        companion object
    }

    data class Attachment(
            @JsonProperty("fallback") val fallback: String?,
            @JsonProperty("id") val id: Int,
            @JsonProperty("text") val text: String?
    ) {
        companion object
    }
}


@JacksonDataClass
data class ErrorChannelsHistoryResponse constructor(override val ok: Boolean,
                                                    @JsonProperty("error") val error: String)
    : ChannelsHistoryResponse(ok) {

    companion object
}

@JacksonDataClass
data class ChannelsHistoryRequest constructor(@JsonProperty("channel") val channelId: String,
                                              @JsonProperty("count") val count: Int? = null,
                                              @JsonProperty("inclusive") val inclusive: Boolean? = null,
                                              @InstantToString @JsonProperty("latest") val latestTimestamp: Instant? = null,
                                              @InstantToString @JsonProperty("oldest") val oldestTimestamp: Instant? = null,
                                              @JsonProperty("unreads") val unreads: Boolean? = null
) {
    companion object {}

    fun toRequestMap(): Map<String, String> {
        val requestMap = mutableMapOf("channel" to channelId)
        count?.let { requestMap.put("count", it.toString()) }
        inclusive?.let { requestMap.put("inclusive", it.toString()) }
        latestTimestamp?.let { requestMap.put("latest", it.toString()) }
        oldestTimestamp?.let { requestMap.put("oldest", it.toString()) }
        unreads?.let { requestMap.put("unreads", it.toString()) }
        return requestMap

    }
}


