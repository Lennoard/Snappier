package br.com.androidvip.snappier.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.domain.entities.Video

@Composable
expect fun NativeVideoPlayer(modifier: Modifier, video: Video)
