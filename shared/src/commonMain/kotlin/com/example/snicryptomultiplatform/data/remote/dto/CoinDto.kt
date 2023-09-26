package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CoinDto(

	@SerialName("symbol")
	val symbol: String? = null,

	@SerialName("is_active")
	val isActive: Boolean? = null,

	@SerialName("is_new")
	val isNew: Boolean? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("rank")
	val rank: Int? = null,

	@SerialName("id")
	val id: String? = null,

	@SerialName("type")
	val type: String? = null
)
