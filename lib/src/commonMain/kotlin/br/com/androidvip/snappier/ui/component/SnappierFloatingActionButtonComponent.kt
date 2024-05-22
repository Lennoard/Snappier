package br.com.androidvip.snappier.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.data.FloatingActionButtonData
import br.com.androidvip.snappier.ui.utils.composeColor

class SnappierFloatingActionButtonComponent : SnappierObservableComponent(ID) {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            content.fab?.let { fab ->
                SnappierFloatingActionButton(
                    onClick = {
                        content.events?.find { it.trigger == EventTrigger.OnClick }?.let { event ->
                            emmitEvent(event)
                        }
                    },
                    fab = fab
                )
            }
        }
    }

    companion object {
        const val ID = "snappier_fab"
    }
}

@Composable
fun SnappierFloatingActionButton(
    onClick: () -> Unit,
    fab: FloatingActionButtonData
) {
    val border = fab.border
    val stroke = fab.stroke
    val shape = if (border != null) {
        if (border.percent != null) {
            RoundedCornerShape(percent = border.percent.toInt())
        } else {
            RoundedCornerShape(
                topStart = border.topLeft,
                topEnd = border.topRight,
                bottomStart = border.bottomLeft,
                bottomEnd = border.bottomRight
            )
        }
    } else {
        FloatingActionButtonDefaults.extendedFabShape
    }

    ExtendedFloatingActionButton(
        onClick = onClick,
        modifier = if (stroke != null) {
            Modifier.border(
                border = BorderStroke(
                    width = stroke.width.dp,
                    color = stroke.color.composeColor()
                ),
                shape = shape
            )
        } else {
            Modifier
        },
        containerColor = fab.backgroundColor.composeColor(),
        contentColor = if (fab.color != null) {
            fab.color.composeColor()
        } else {
            contentColorFor(fab.backgroundColor.composeColor())
        },
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = fab.shadow?.elevation?.dp ?: 6.dp
        ),
        shape = shape
    ) {
        fab.text?.let { text ->
            SnappierText(null, text)
        }
        fab.icon?.let { icon ->
            SnappierIconButton(icon.copy(events = fab.events))
        }
    }
}
