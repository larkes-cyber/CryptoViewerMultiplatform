package com.example.snicryptomultiplatform.domain.repository

import com.example.snicryptomultiplatform.domain.model.Coin
import com.example.snicryptomultiplatform.domain.model.CoinDetail
import com.example.snicryptomultiplatform.until.Resource

interface CoinRepository {

    suspend fun getCoins():Resource<List<Coin>>
    suspend fun getCoinById(coinId:String):Resource<CoinDetail>

}