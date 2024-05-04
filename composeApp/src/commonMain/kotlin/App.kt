import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.Snappier
import io.ktor.http.HttpMethod
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val snappier = Snappier {
        onLoadingErrorComposable { progress ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Loading: $progress%")
            }
        }

        onErrorComposable {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $it")
            }
        }

        setHttpMethod(HttpMethod.Get)
    }.apply {
        addObserver { event ->
            println("Received event: $event")
        }
    }

    MaterialTheme {
        snappier.draw("http://localhost:8081/api")
    }
}
