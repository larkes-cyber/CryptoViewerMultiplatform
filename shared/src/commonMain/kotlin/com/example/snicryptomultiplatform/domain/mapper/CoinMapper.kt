package com.example.snicryptomultiplatform.domain.mapper

import com.example.snicryptomultiplatform.data.remote.dto.CoinDetailDto
import com.example.snicryptomultiplatform.data.remote.dto.CoinDto
import com.example.snicryptomultiplatform.data.remote.dto.TeamMember
import com.example.snicryptomultiplatform.domain.model.Coin
import com.example.snicryptomultiplatform.domain.model.CoinDetail

fun CoinDto.toCoin():Coin{
    return Coin(
        id = id!!,
        isActive = isActive!!,
        name = name!!,
        rank = rank!!,
        symbol = symbol!!
    )
}

fun CoinDetailDto.toCoinDetail():CoinDetail{
    return CoinDetail(
        coinId = id!!,
        name = name!!,
        description = description!!,
        symbol = symbol!!,
        rank = rank!!,
        isActive = isActive!!,
        tags = tags!!.map { it!!.name!! },
        team = team!!.map { it!! }
    )
}

