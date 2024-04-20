package ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import component.base.Content
import component.base.Event
import component.data.TextData
import engine.SnappierComponentData
import engine.SnappierObservableComponent
import ui.utils.composeColor
import ui.utils.snappierModifier
import ui.utils.textAlignment

class SnappierTextComponent : SnappierObservableComponent("snappier_text") {

    @Composable
    override fun render(data: SnappierComponentData) {
        data.contents.firstOrNull()?.let { content ->
            val text = content.texts.firstOrNull() ?: TextData()
            SnappierText(
                content = content,
                text = text,
                onClick = { emmitEvent(it) },
                onLongClick = { emmitEvent(it) },
                onDraw = { emmitEvent(it) }
            )
        }
    }
}

@Composable
internal fun SnappierText(
    content: Content?,
    text: TextData,
    onClick: ((Event) -> Unit)? = null,
    onLongClick: ((Event) -> Unit)? = null,
    onDraw: ((Event) -> Unit)? = null
) {
    Text(
        text = text.text,
        color = text.color.composeColor(),
        fontSize = text.size.sp,
        textAlign = text.alignment.textAlignment(),
        fontWeight = FontWeight(text.weight),
        modifier = Modifier.snappierModifier(
            content = content,
            constraints = text.constraints,
            onClick = onClick,
            onLongClick = onLongClick,
            onDraw = onDraw
        )
    )
}
