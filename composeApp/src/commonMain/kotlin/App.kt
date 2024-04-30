
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.Snappier
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.Component
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var sampleComponent by remember { mutableStateOf<Component?>(null) }
    var loading by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val client = HttpClient {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
    }
    val snappier = Snappier().apply {
        customObserver = EventObserver { event ->
            println("Received event: $event")
        }
    }

    LaunchedEffect(true) {
        scope.launch {
            delay(500)
            runCatching {
                // To test this, go to /api and run "npm run start"
                sampleComponent = client.get("http://localhost:8080/api").body()
            }
            loading = false
            client.close()
        }
    }

    MaterialTheme {
        AnimatedVisibility(loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        // Sample content data from API
        AnimatedVisibility(!loading) {
            if (sampleComponent != null) {
                snappier.draw(sampleComponent!!)
            } else {
                Text("Failed to get sample Component from API")
            }
        }
    }
}
