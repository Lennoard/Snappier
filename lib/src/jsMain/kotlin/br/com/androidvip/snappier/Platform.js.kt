package br.com.androidvip.snappier

actual fun getPlatform(): Platform = object : Platform {
    override val name: String
        get() = "js"
}
