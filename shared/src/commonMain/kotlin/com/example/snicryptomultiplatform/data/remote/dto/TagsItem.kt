package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TagsItem(

	@SerialName("coin_counter")
	val coinCounter: Int? = null,

	@SerialName("ico_counter")
	val icoCounter: Int? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: String? = null
)