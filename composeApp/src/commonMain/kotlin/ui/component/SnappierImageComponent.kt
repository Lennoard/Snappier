package ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox
import component.data.ImageData
import engine.SnappierComponent
import engine.SnappierComponentData
import ui.utils.composeColor
import ui.utils.contentScale

class SnappierImageComponent : SnappierComponent {
    override val id = "snappier_image"

    @Composable
    override fun render(data: SnappierComponentData) {
        data.contents.firstOrNull()?.let { content ->
            val image = content.images.firstOrNull() ?: ImageData()
            SnappierImage(image)
        }
    }
}

@Composable
internal fun SnappierImage(image: ImageData) {
    AutoSizeBox(image.url) { action ->
        when (action) {
            is ImageAction.Success -> {
                Image(
                    rememberImageSuccessPainter(action),
                    contentDescription = image.description,
                    modifier = image.imageModifier(),
                    contentScale = image.scaleType.contentScale()
                )
            }

            is ImageAction.Loading -> {
                if (image.constraints != null) {
                    Box(
                        modifier = image.constraintsModifier(),
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

private fun ImageData?.imageModifier(): Modifier {
    return Modifier.focusable().run {
        var result: Modifier

        result = constraintsModifier()

        val shape = if (this@imageModifier?.border != null) {
            RoundedCornerShape(
                topStart = border.topLeft,
                topEnd = border.topRight,
                bottomStart = border.bottomLeft,
                bottomEnd = border.bottomRight
            )
        } else {
            RectangleShape
        }

        if (this@imageModifier?.border != null) {
            result = clip(shape)
        }

        if (this@imageModifier?.stroke != null) {
            result = border(stroke.width.dp, stroke.color.composeColor(), shape).clip(shape)
        }

        result
    }
}

private fun ImageData?.constraintsModifier(): Modifier {
    return Modifier.focusable().run {
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
