package com.example.snicryptomultiplatform.data.remote.http_client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

actual fun httpClient(config: HttpClientConfig<*>.()-> Unit) = HttpClient(CIO) {
    install(ContentNegotiation){
        json(Json{
            prettyPrint = true
            isLenient = true
        })
    }
}