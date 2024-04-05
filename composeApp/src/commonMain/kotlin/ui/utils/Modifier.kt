package ui.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import component.base.Constraints
import component.base.Content
import component.base.EventTrigger

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.snappierModifier(
    content: Content,
    constraints: Constraints? = null,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    onDraw: (() -> Unit)? = null
): Modifier {
    return focusable().run {
        var result = this

        content.backgroundColor?.let { result = result.background(it.composeColor()) }
        content.description?.let {
            result = result.semantics { contentDescription = it }
        }

        content.events.forEach { event ->
            when (event.trigger) {
                EventTrigger.OnClick,
                EventTrigger.OnLongCLick -> result = result.combinedClickable(
                    onClick = { onClick?.invoke() },
                    onLongClick = { onLongClick?.invoke() }
                )
                EventTrigger.OnDraw -> SideEffect { onDraw?.invoke() }
                null -> {} // NO-OP
            }
        }

        if (constraints != null) {
            constraints.width.takeIf { it > 0 }?.let {
                result = result.requiredWidth(it.dp)
            }
            constraints.height.takeIf { it > 0 }?.let {
                result = result.requiredHeight(it.dp)
            }
        }

        result
    }
}
