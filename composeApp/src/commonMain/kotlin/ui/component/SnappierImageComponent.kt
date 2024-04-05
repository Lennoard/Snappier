package ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox
import component.base.Constraints
import component.data.ImageData
import engine.SnappierComponent
import engine.SnappierComponentData
import ui.utils.contentScale

class SnappierImageComponent : SnappierComponent {
    override val id = "snappier_image"

    @Composable
    override fun render(data: SnappierComponentData) {
        data.contents.firstOrNull()?.let { content ->
            val image = content.images.firstOrNull() ?: ImageData()
            AutoSizeBox(image.url) { action ->
                when (action) {
                    is ImageAction.Success -> {
                        Image(
                            rememberImageSuccessPainter(action),
                            contentDescription = image.description,
                            modifier = imageModifier(image.constraints),
                            contentScale = image.scaleType.contentScale()
                        )
                    }
                    is ImageAction.Loading -> {
                        if (image.constraints != null) {
                            Box(
                                modifier = imageModifier(image.constraints),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                    is ImageAction.Failure -> {}
                }
            }
        }
    }

    private fun imageModifier(constraints: Constraints?): Modifier {
        return Modifier.focusable().run {
            var result = this

            if (constraints != null) {
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
