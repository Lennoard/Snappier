package presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration

@ReadOnlyComposable
@Composable
actual fun getScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}
