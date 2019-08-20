package com.kreait.slack.api.contract.jackson.group.groups

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
        JsonSubTypes.Type(value = SuccessfulGroupsHistoryResponse::class, name = "true"),
        JsonSubTypes.Type(value = ErrorGroupsHistoryResponse::class, name = "false")
)

@JacksonDataClass
sealed class GroupsHistoryResponse constructor(@JsonProperty("ok") open val ok: Boolean)

/**
 * [SlackDoc](https://api.slack.com/methods/groups.history)
 */
data class SuccessfulGroupsHistoryResponse(
        override val ok: Boolean,
        @InstantToString @JsonProperty("latest") val latestTimestamp: Instant,
        @JsonProperty("messages") val messages: List<Message>,
        @JsonProperty("has_more") val hasMore: Boolean? = null
) : GroupsHistoryResponse(ok) {
    companion object {}

    data class Message(
            @field:JsonProperty("is_starred") @param:JsonProperty("is_starred") val isStarred: Boolean? = null,
            @JsonProperty("text") val text: String? = null,
            @InstantToString @JsonProperty("ts") val timestamp: Instant?,
            @JsonProperty("type") val type: String? = null,
            @JsonProperty("user") val user: String? = null
    ) {
        companion object
    }
}

/**
 * [SlackDoc](https://api.slack.com/methods/groups.history)
 */
data class ErrorGroupsHistoryResponse constructor(
        override val ok: Boolean,
        @JsonProperty("error") val error: String
) : GroupsHistoryResponse(ok) {
    companion object
}

/**
 * [SlackDoc](https://api.slack.com/methods/groups.history)
 */
data class GroupsHistoryRequest(@JsonProperty("channel") val channelId: String,
                                @JsonProperty("count") val count: Int? = null,
                                @JsonProperty("inclusive") val inclusive: Boolean = false,
                                @InstantToString @JsonProperty("latest") val latestTimestamp: Instant? = null,
                                @InstantToString @JsonProperty("oldest") val oldestTimestamp: Instant? = null,
                                @JsonProperty("unreads") val unreads: Boolean = false) {
    companion object
}