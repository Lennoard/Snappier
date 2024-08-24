package br.com.androidvip.snappier.ui.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.SnappierEvent
import br.com.androidvip.snappier.domain.component.base.EventTrigger

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.snappierModifier(
    content: Content?,
    constraints: Constraints? = null,
    onClick: ((SnappierEvent) -> Unit)? = null,
    onLongClick: ((SnappierEvent) -> Unit)? = null,
    onDraw: ((SnappierEvent) -> Unit)? = null
): Modifier {
    return focusable().run {
        var result = this

        content?.backgroundColor?.let { result = result.background(it.composeColor()) }
        content?.description?.let {
            result = result.semantics { contentDescription = it }
        }

        content?.events?.forEach { event ->
            when (event.trigger) {
                EventTrigger.OnClick,
                EventTrigger.OnLongCLick -> result = result.combinedClickable(
                    onClick = { onClick?.invoke(event) },
                    onLongClick = { onLongClick?.invoke(event) }
                )

                EventTrigger.OnDraw -> LaunchedEffect(Unit) { onDraw?.invoke(event) }
                else -> {} // NO-OP
            }
        }

        if (constraints != null) {
            constraints.width.let {
                result = when {
                    it < 0 -> result.fillMaxWidth()
                    it > 0 -> result.requiredWidth(it.dp)
                    else -> result.wrapContentWidth()
                }
            }
            constraints.height.let {
                result = when {
                    it < 0 -> result.fillMaxHeight()
                    it > 0 -> result.requiredHeight(it.dp)
                    else -> result.wrapContentHeight()
                }
            }
        }

        result
    }
}
