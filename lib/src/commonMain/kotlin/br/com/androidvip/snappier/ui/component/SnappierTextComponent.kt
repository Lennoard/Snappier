package br.com.androidvip.snappier.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.androidvip.snappier.data.models.TextDTO
import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.entities.Text
import br.com.androidvip.snappier.ui.utils.composeColor
import br.com.androidvip.snappier.ui.utils.snappierModifier
import br.com.androidvip.snappier.ui.utils.textAlignment

class SnappierTextComponent : SnappierObservableComponent(ID) {

    @Composable
    override fun View(data: Component, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            val text = content.texts?.firstOrNull() ?: TextDTO()
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
fun SnappierText(
    content: Content?,
    text: Text,
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
