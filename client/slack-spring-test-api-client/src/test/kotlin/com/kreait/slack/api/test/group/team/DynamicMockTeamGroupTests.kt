package com.kreait.slack.api.test.group.team

import com.kreait.slack.api.contract.jackson.group.team.ErrorProfileResponse
import com.kreait.slack.api.contract.jackson.group.team.ProfileRequest
import com.kreait.slack.api.contract.jackson.group.team.SuccessfulProfileResponse
import com.kreait.slack.api.contract.jackson.group.team.sample
import com.kreait.slack.api.test.DynamicMockGroupTests
import com.kreait.slack.api.test.MockMetaInfo
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class DynamicMockTeamGroupTests {


    @TestFactory
    fun methodInvocations(): List<DynamicTest> = DynamicMockGroupTests.methodInvocations(testCases = testCases())

    private fun testCases() = listOf(
            MockMetaInfo(MockTeamGetProfileMethod(), mock { }, SuccessfulProfileResponse.sample(), mock { }, ErrorProfileResponse.sample(), ProfileRequest.sample())
    )
}