package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class Tag(
    @SerialName("coin_counter")
    val coinCounter: Int,
    @SerialName("ico_counter")
    val icoCounter: Int,
    val id: String,
    val name: String
)