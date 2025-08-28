package br.com.androidvip.snappier.config

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json

class SnappierConfig internal constructor(
    internal var onError: (@Composable (error: Throwable) -> Unit)? = null,
    internal var onLoading: (@Composable (progress: Int) -> Unit)? = null,
    internal var httpMethod: HttpMethod = HttpMethod.Get,
    internal var httpClient: HttpClient = defaultHttpClient
) {

    fun onErrorComposable(function: @Composable (error: Throwable) -> Unit): SnappierConfig {
        onError = function
        return this
    }

    fun onLoadingComposable(function: @Composable (progress: Int) -> Unit): SnappierConfig {
        onLoading = function
        return this
    }

    fun setHttpMethod(method: HttpMethod): SnappierConfig {
        httpMethod = method
        return this
    }

    fun setHttpClient(client: HttpClient): SnappierConfig {
        httpClient = client
        return this
    }

    fun withHttpClient(block: HttpClientConfig<*>.() -> Unit): SnappierConfig {
        httpClient = HttpClient(block)
        return this
    }

    companion object {
        private val defaultHttpClient by lazy {
            HttpClient {
                install(Logging)
                install(ContentNegotiation) {
                    json()
                }
            }
        }

        val defaultConfig = SnappierConfig(
            onLoading = { progress ->
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Loading: $progress%")
                }
            }
        )
    }
}
