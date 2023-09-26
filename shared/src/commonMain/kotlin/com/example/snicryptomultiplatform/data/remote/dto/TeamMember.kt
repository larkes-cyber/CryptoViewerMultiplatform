package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TeamMember(

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: String? = null,

	@SerialName("position")
	val position: String? = null
)