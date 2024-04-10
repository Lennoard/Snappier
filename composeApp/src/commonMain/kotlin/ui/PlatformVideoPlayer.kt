package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import component.data.VideoData

@Composable
expect fun PlatformVideoPlayer(modifier: Modifier, videoData: VideoData)
