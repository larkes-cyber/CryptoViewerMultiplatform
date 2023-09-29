package com.example.snicryptomultiplatform.domain.model

import com.example.snicryptomultiplatform.data.remote.dto.TeamItem


data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamItem>
)
