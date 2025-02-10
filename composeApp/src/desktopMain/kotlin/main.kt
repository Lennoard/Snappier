import android.app.Application
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.google.firebase.FirebasePlatform
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import firebase.DefaultFirebasePlatform
import firebase.firebaseOptions

fun main() = application {
    FirebasePlatform.initializeFirebasePlatform(DefaultFirebasePlatform)
    Firebase.initialize(Application(), firebaseOptions)

    Window(
        onCloseRequest = ::exitApplication,
        title = "Snappier",
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = 411.dp,
            height = 720.dp
        )
    ) {
        App()
    }
}
