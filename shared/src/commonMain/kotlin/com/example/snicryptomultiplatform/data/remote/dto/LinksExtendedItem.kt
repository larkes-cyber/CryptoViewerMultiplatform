package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class LinksExtendedItem(

	@SerialName("type")
	val type: String? = null,

	@SerialName("url")
	val url: String? = null,

	@SerialName("stats")
	val stats: Stats? = null
)