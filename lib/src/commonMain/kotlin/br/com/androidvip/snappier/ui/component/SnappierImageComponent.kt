package br.com.androidvip.snappier.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.data.ImageData
import br.com.androidvip.snappier.ui.utils.composeColor
import br.com.androidvip.snappier.ui.utils.contentScale
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox

class SnappierImageComponent : SnappierObservableComponent("snappier_image") {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            val image = content.images?.firstOrNull() ?: ImageData()
            SnappierImage(
                image = image,
                onClick = { emmitEvent(it) },
                onLongClick = { emmitEvent(it) },
                onDraw = { emmitEvent(it) }
            )
        }
    }
}

@Composable
internal fun SnappierImage(
    image: ImageData,
    onClick: ((Event) -> Unit)? = null,
    onLongClick: ((Event) -> Unit)? = null,
    onDraw: ((Event) -> Unit)? = null
) {
    AutoSizeBox(image.url) { action ->
        when (action) {
            is ImageAction.Success -> {
                Image(
                    rememberImageSuccessPainter(action),
                    contentDescription = image.description,
                    modifier = image.imageModifier(onClick, onLongClick, onDraw),
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

@Composable
private fun ImageData?.imageModifier(
    onClick: ((Event) -> Unit)? = null,
    onLongClick: ((Event) -> Unit)? = null,
    onDraw: ((Event) -> Unit)? = null
): Modifier {
    return Modifier.focusable().run {
        var result: Modifier

        result = constraintsModifier(onClick, onLongClick, onDraw)

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

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun ImageData?.constraintsModifier(
    onClick: ((Event) -> Unit)? = null,
    onLongClick: ((Event) -> Unit)? = null,
    onDraw: ((Event) -> Unit)? = null
): Modifier {
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

        this@constraintsModifier?.events?.forEach { event ->
            when (event.trigger) {
                EventTrigger.OnClick,
                EventTrigger.OnLongCLick -> result = result.combinedClickable(
                    onClick = { onClick?.invoke(event) },
                    onLongClick = { onLongClick?.invoke(event) }
                )

                EventTrigger.OnDraw -> SideEffect { onDraw?.invoke(event) }
                else -> {} // NO-OP
            }
        }

        result
    }
}
