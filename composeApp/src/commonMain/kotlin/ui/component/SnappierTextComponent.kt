package ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import component.base.Content
import component.data.TextData
import engine.SnappierComponent
import engine.SnappierComponentData
import ui.utils.composeColor
import ui.utils.snappierModifier
import ui.utils.textAlignment

class SnappierTextComponent : SnappierComponent {
    override val id = "snappier_text"

    @Composable
    override fun render(data: SnappierComponentData) {
        data.contents.firstOrNull()?.let { content ->
            val text = content.texts.firstOrNull() ?: TextData()
            SnappierText(content, text)
        }
    }
}

@Composable
internal fun SnappierText(content: Content?, text: TextData) {
    Text(
        text = text.text,
        color = text.color.composeColor(),
        fontSize = text.size.sp,
        textAlign = text.alignment.textAlignment(),
        fontWeight = FontWeight(text.weight),
        modifier = Modifier.snappierModifier(content, text.constraints)
    )
}
