package com.example.snicryptomultiplatform.data.source

import com.example.snicryptomultiplatform.data.remote.dto.CoinDetailDto
import com.example.snicryptomultiplatform.data.remote.dto.CoinDto
import com.example.snicryptomultiplatform.domain.model.Coin
import com.example.snicryptomultiplatform.until.Resource

interface CoinRemoteDataSource {

    suspend fun getCoins():Resource<List<CoinDto>>
    suspend fun getCoinById(coinId:String):Resource<CoinDetailDto>

    companion object{
        const val BASE_URL = "https://api.coinpaprika.com/"
    }

    sealed class Endpoints(val url: String){
        object Coins: Endpoints("$BASE_URL/v1/coins")
        object CoinDetail: Endpoints("$BASE_URL/v1/coins/")
    }
}