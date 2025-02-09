import android.app.Application
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.google.firebase.FirebasePlatform
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import firebase.DefaultFirebasePlatform
import firebase.firebaseOptions

fun main() = application {
    FirebasePlatform.initializeFirebasePlatform(DefaultFirebasePlatform)
    Firebase.initialize(Application(), firebaseOptions)

    Window(onCloseRequest = ::exitApplication, title = "Snappier") {
        App()
    }
}
