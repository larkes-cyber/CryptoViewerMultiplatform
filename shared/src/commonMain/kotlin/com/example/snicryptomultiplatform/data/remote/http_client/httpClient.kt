package com.example.snicryptomultiplatform.data.remote.http_client

import io.ktor.client.*

expect fun httpClient(config: HttpClientConfig<*>.()-> Unit={}):HttpClient