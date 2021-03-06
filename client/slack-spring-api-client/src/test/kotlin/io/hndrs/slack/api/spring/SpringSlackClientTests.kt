package io.hndrs.slack.api.spring

import io.hndrs.slack.api.spring.group.auth.SpringAuthMethodGroup
import io.hndrs.slack.api.spring.group.chat.SpringChatMethodGroup
import io.hndrs.slack.api.spring.group.conversations.SpringConversationsMethodGroup
import io.hndrs.slack.api.spring.group.dialog.SpringDialogMethodGroup
import io.hndrs.slack.api.spring.group.oauth.SpringOauthMethodGroup
import io.hndrs.slack.api.spring.group.pins.SpringPinsMethodGroup
import io.hndrs.slack.api.spring.group.reminders.SpringRemindersMethodGroup
import io.hndrs.slack.api.spring.group.respond.SpringRespondMethodGroup
import io.hndrs.slack.api.spring.group.team.SpringTeamMethodGroup
import io.hndrs.slack.api.spring.group.usergroups.SpringUsergroupMethodGroup
import io.hndrs.slack.api.spring.group.users.SpringUserMethodGroup
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SpringSlackClientTests {
    private val springSlackClient = io.hndrs.slack.api.spring.SpringSlackClient()

    @DisplayName("Check RespondMethodGroup")
    @Test
    fun testRespondGroup() {
        assert(springSlackClient.respond() is SpringRespondMethodGroup)
    }

    @DisplayName("Check AuthMethodGroup")
    @Test
    fun testAuthGroup() {
        assert(springSlackClient.auth() is SpringAuthMethodGroup)
    }

    @DisplayName("Check ChatMethodGroup")
    @Test
    fun testChatGroup() {
        assert(springSlackClient.chat() is SpringChatMethodGroup)
    }

    @DisplayName("Check DialogMethodGroup")
    @Test
    fun testDialogGroup() {
        assert(springSlackClient.dialog() is SpringDialogMethodGroup)
    }

    @DisplayName("Check ConversationMethodGroup")
    @Test
    fun testConversationGroup() {
        assert(springSlackClient.conversation() is SpringConversationsMethodGroup)
    }

    @DisplayName("Check UsersMethodGroup")
    @Test
    fun testUsersGroup() {
        assert(springSlackClient.users() is SpringUserMethodGroup)
    }

    @DisplayName("Check OauthMethodGroup")
    @Test
    fun testOauthGroup() {
        assert(springSlackClient.oauth() is SpringOauthMethodGroup)
    }

    @DisplayName("Check TeamMethodGroup")
    @Test
    fun testTeamGroup() {
        assert(springSlackClient.team() is SpringTeamMethodGroup)
    }

    @DisplayName("Check UserGroupsMethodGroup")
    @Test
    fun testUserGroupsGroup() {
        assert(springSlackClient.usergroups() is SpringUsergroupMethodGroup)
    }

    @DisplayName("Check RemindersMethodGroup")
    @Test
    fun testRemindersGroup() {
        assert(springSlackClient.reminders() is SpringRemindersMethodGroup)
    }

    @DisplayName("Check PinsMethodGroup")
    @Test
    fun testPinsGroup() {
        assert(springSlackClient.pins() is SpringPinsMethodGroup)
    }
}
