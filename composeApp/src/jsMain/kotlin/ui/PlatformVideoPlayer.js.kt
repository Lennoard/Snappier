package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.data.VideoData

@Composable
actual fun PlatformVideoPlayer(modifier: Modifier, videoData: VideoData) {
    // TODO
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().height(200.dp)
    ) {
        Text("Reprodução de vídeos ainda não está disponível")
    }
}
