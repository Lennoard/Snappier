package br.com.androidvip.snappier.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.data.TextData
import br.com.androidvip.snappier.ui.utils.composeColor
import br.com.androidvip.snappier.ui.utils.snappierModifier
import br.com.androidvip.snappier.ui.utils.textAlignment

class SnappierTextComponent : SnappierObservableComponent(ID) {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            val text = content.texts?.firstOrNull() ?: TextData()
            SnappierText(
                content = content,
                text = text,
                onClick = { emmitEvent(it) },
                onLongClick = { emmitEvent(it) },
                onDraw = { emmitEvent(it) }
            )
        }
    }

    companion object {
        const val ID = "snappier_text"
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
