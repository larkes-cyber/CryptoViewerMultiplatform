package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)