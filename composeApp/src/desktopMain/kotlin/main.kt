import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
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
