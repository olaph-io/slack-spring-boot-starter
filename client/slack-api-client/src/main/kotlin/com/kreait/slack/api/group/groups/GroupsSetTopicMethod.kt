package com.kreait.slack.api.group.groups

import com.kreait.slack.api.contract.jackson.group.groups.ErrorGroupsSetTopicResponse
import com.kreait.slack.api.contract.jackson.group.groups.GroupsSetTopicRequest
import com.kreait.slack.api.contract.jackson.group.groups.SuccessfulGroupsSetTopicResponse
import com.kreait.slack.api.group.ApiCallMethod

abstract class GroupsSetTopicMethod : ApiCallMethod<GroupsSetTopicMethod, SuccessfulGroupsSetTopicResponse, ErrorGroupsSetTopicResponse, GroupsSetTopicRequest>()