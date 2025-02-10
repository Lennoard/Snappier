package presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo

@OptIn(ExperimentalComposeUiApi::class)
@ReadOnlyComposable
@Composable
actual fun getScreenWidth(): Int {
    return LocalWindowInfo.current.containerSize.width
}
