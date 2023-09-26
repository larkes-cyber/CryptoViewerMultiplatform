package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Whitepaper(

	@SerialName("thumbnail")
	val thumbnail: String? = null,

	@SerialName("link")
	val link: String? = null
)