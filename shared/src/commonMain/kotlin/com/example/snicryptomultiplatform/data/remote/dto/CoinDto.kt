package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class CoinDto(
    val id: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
