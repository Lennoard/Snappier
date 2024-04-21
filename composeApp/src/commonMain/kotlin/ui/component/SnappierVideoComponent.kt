package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import component.base.EventTrigger
import component.data.VideoData
import engine.SnappierComponentData
import engine.SnappierObservableComponent
import ui.PlatformVideoPlayer

class SnappierVideoComponent : SnappierObservableComponent("snappier_video") {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            content.videos.firstOrNull()?.let { videoData ->
                PlatformVideoPlayer(
                    modifier = videoData.constraintsModifier(),
                    videoData = videoData
                )

                SideEffect {
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
