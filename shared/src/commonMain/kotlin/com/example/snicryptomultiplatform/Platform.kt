package com.example.snicryptomultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform