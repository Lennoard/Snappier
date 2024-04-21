package ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import component.base.Content
import component.base.EventTrigger
import component.data.ButtonData
import engine.SnappierComponentData
import engine.SnappierObservableComponent
import ui.utils.composeColor
import ui.utils.snappierModifier

class SnappierButtonComponent : SnappierObservableComponent("snappier_button") {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            content.buttons.firstOrNull()?.let { button ->
                extras?.let {
                    Text("I received some extras: $extras")
                }
                SnappierButton(
                    onClick = {
                        content.events.find { it.trigger == EventTrigger.OnClick }?.let { event ->
                            emmitEvent(event)
                        }
                    },
                    content = content,
                    button = button
                )
            }
        }
    }
}

@Composable
internal fun SnappierButton(onClick: () -> Unit, content: Content?, button: ButtonData) {
    val border = button.border
    val stroke = button.stroke
    Button(
        modifier = Modifier.snappierModifier(content, constraints = button.constraints),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = button.backgroundColor.composeColor(),
            contentColor = button.color.composeColor()
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = button.shadow?.elevation?.dp ?: 0.dp
        ),
        border = if (stroke != null) {
            BorderStroke(
                width = stroke.width.dp,
                color = stroke.color.composeColor()
            )
        } else {
            null
        },
        shape = if (border != null) {
            RoundedCornerShape(
                topStart = border.topLeft,
                topEnd = border.topRight,
                bottomStart = border.bottomLeft,
                bottomEnd = border.bottomRight
            )
        } else {
            ButtonDefaults.shape
        }
    ) {
        Text(
            text = button.title,
            color = button.color.composeColor(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
