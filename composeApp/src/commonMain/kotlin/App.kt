import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.Snappier
import br.com.androidvip.snappier.domain.component.base.Element
import data.di.dataModule
import domain.DataSource
import domain.repository.SnappierRepository
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
fun App() {
    KoinApplication(application = {
        modules(dataModule)
    }) {
        SnappierScreen()
    }
}

@Composable
private fun SnappierScreen(repository: SnappierRepository = koinInject()) {
    val snappier = Snappier {
        onErrorComposable {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $it")
            }
        }
    }.apply {
        addObserver { event ->
            println("Received event: $event")
        }
    }

    var element by remember { mutableStateOf<Element?>(null) }

    LaunchedEffect(Unit) {
        repository.getHomeScreenElement(DataSource.FirebaseDatabase).collect {
            element = it
        }
    }

    MaterialTheme {
        with(snappier) {
            if (element != null) {
                SnappierView(element!!)
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Text(
                        text = "Loading...",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}
