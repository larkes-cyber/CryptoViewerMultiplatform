package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Links(

	@SerialName("youtube")
	val youtube: List<String?>? = null,

	@SerialName("website")
	val website: List<String?>? = null,

	@SerialName("facebook")
	val facebook: List<String?>? = null,

	@SerialName("explorer")
	val explorer: List<String?>? = null,

	@SerialName("reddit")
	val reddit: List<String?>? = null,

	@SerialName("source_code")
	val sourceCode: List<String?>? = null
)