package com.example.snicryptomultiplatform.data.repository


import com.example.snicryptomultiplatform.data.source.CoinRemoteDataSource
import com.example.snicryptomultiplatform.domain.mapper.toCoin
import com.example.snicryptomultiplatform.domain.mapper.toCoinDetail
import com.example.snicryptomultiplatform.domain.model.Coin
import com.example.snicryptomultiplatform.domain.model.CoinDetail
import com.example.snicryptomultiplatform.domain.repository.CoinRepository
import com.example.snicryptomultiplatform.until.Resource

class CoinRepositoryImpl(
    private val coinRemoteDataSource: CoinRemoteDataSource
):CoinRepository {
    override suspend fun getCoins(): Resource<List<Coin>> {
        return when(val result = coinRemoteDataSource.getCoins()){
            is Resource.Success -> Resource.Success(result.data!!.map { it.toCoin() })
            is Resource.Error -> Resource.Error(result.message!!)
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return when(val result =  coinRemoteDataSource.getCoinById(coinId)){
            is Resource.Success -> Resource.Success(result.data!!.toCoinDetail())
            is Resource.Error -> Resource.Error(result.message!!)
        }
    }
}