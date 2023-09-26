package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Stats(

	@SerialName("followers")
	val followers: Int? = null,

	@SerialName("members")
	val members: Int? = null,

	@SerialName("contributors")
	val contributors: Int? = null,

	@SerialName("stars")
	val stars: Int? = null,

	@SerialName("subscribers")
	val subscribers: Int? = null
)