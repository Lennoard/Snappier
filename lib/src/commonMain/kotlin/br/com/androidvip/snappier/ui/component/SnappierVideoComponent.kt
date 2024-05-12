package br.com.androidvip.snappier.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.data.VideoData
import br.com.androidvip.snappier.ui.NativeVideoPlayer

class SnappierVideoComponent : SnappierObservableComponent("snappier_video") {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            content.videos?.firstOrNull()?.let { videoData ->
                NativeVideoPlayer(
                    modifier = videoData.constraintsModifier(),
                    videoData = videoData
                )

                LaunchedEffect(Unit) {
                    videoData.events.find { it.trigger == EventTrigger.OnDraw }?.let {
                        emmitEvent(it)
                    }
                }
            }
        }
    }

    private fun VideoData?.constraintsModifier(): Modifier {
        return Modifier.background(Color.Transparent).run {
            var result = this
            if (this@constraintsModifier?.constraints != null) {
                result = if (constraints.width <= 0) {
                    result.fillMaxWidth()
                } else {
                    result.requiredWidth(constraints.width.dp)
                }

                constraints.height.takeIf { it > 0 }?.let {
                    result = result.requiredHeight(it.dp)
                }
            }

            result
        }
    }
}
