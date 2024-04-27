package br.com.androidvip.snappier.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import br.com.androidvip.snappier.data.VideoCacheController
import br.com.androidvip.snappier.ui.component.data.VideoData
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.cache.CacheDataSource

@Composable
actual fun NativeVideoPlayer(modifier: Modifier, videoData: VideoData) {
    val context = LocalContext.current
    val cacheDataSourceFactory = VideoCacheController().getCacheDataSourceFactory(context)
    val exoPlayer by remember {
        mutableStateOf(getPlayer(context, videoData.url, cacheDataSourceFactory))
    }

    AndroidView(
        factory = {
            StyledPlayerView(context).apply {
                setShowBuffering(StyledPlayerView.SHOW_BUFFERING_ALWAYS)
                useController = !videoData.hideControls
                player = exoPlayer
            }
        },
        update = {
            if (videoData.autoPlay) {
                it.player?.play()
            } else {
                it.player?.prepare()
            }
        }
    )

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }
}

private fun getPlayer(
    context: Context,
    url: String,
    cacheDataSourceFactory: CacheDataSource.Factory
): ExoPlayer {
    val mediaItem = MediaItem.Builder().setUri(url).build()

    val mediaSources = buildList<MediaSource> {
        add(ProgressiveMediaSource.Factory(cacheDataSourceFactory).createMediaSource(mediaItem))
        add(HlsMediaSource.Factory(cacheDataSourceFactory).createMediaSource(mediaItem))
    }

    return ExoPlayer.Builder(context)
        .build()
        .apply {
            playWhenReady = false
            repeatMode = Player.REPEAT_MODE_ALL
            videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
            setMediaSources(mediaSources)
            prepare()
        }
}
