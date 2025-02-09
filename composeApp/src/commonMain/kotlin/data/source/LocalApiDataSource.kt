package data.source

import br.com.androidvip.snappier.data.models.ElementDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import kotlinx.coroutines.flow.flow

class LocalApiDataSource(
    private val httpClient: HttpClient
): SnappierDataSource {
    override fun getHomeScreenElement() = flow {
        val request = httpClient.request {
            method = HttpMethod.Get
            url(API_URL)
        }
        emit(request.body<ElementDTO>())
    }

    companion object {
        private const val API_URL = "http://localhost:8081/api"
    }
}