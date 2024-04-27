package br.com.androidvip.snappier

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
