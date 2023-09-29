package com.example.snicryptomultiplatform.data.source

import com.example.snicryptomultiplatform.data.remote.dto.CoinDetailDto
import com.example.snicryptomultiplatform.data.remote.dto.CoinDto
import com.example.snicryptomultiplatform.data.remote.http_client.httpClient
import com.example.snicryptomultiplatform.until.Resource
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class CoinRemoteDataSourceImpl:CoinRemoteDataSource {

    private val client = httpClient(){
        install(ContentNegotiation){
            json(Json{
                prettyPrint = true
                isLenient = true
            })
        }
    }


    override suspend fun getCoins(): Resource<List<CoinDto>> {
        val response: HttpResponse = client.get(CoinRemoteDataSource.Endpoints.Coins.url){
            contentType(ContentType.Application.Json)
        }
       return if(response.status.value == 200) Resource.Success(Json.decodeFromString<List<CoinDto>>(response.bodyAsText()))
              else Resource.Error(response.status.description)
    }

    override suspend fun getCoinById(coinId: String):Resource<CoinDetailDto> {
        val response: HttpResponse = client.get(CoinRemoteDataSource.Endpoints.CoinDetail.url){
            url{
                parameters.append("coinId",coinId)
            }
            contentType(ContentType.Application.Json)
        }
        return if(response.status.value == 200) {
            val res = response.bodyAsText()
            Resource.Success(Json.decodeFromString<CoinDetailDto>(res.substring(1, res.length - 1)))
        }
        else Resource.Error(response.status.description)
    }
}