package br.com.androidvip.snappier.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.ui.component.data.VideoData

@Composable
expect fun NativeVideoPlayer(modifier: Modifier, videoData: VideoData)
