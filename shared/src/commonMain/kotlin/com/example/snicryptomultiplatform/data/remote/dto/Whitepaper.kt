package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable

data class Whitepaper(
    val link: String,
    val thumbnail: String
)