package ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
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
            Text(
                text = text.text,
                color = text.color.composeColor(),
                fontSize = text.size.sp,
                textAlign = text.alignment.textAlignment(),
                modifier = Modifier.snappierModifier(content, text.constraints)
            )
        }
    }
}
