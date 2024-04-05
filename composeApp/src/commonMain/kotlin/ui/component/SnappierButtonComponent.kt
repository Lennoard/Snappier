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
import component.data.ButtonData
import engine.SnappierComponent
import engine.SnappierComponentData
import ui.utils.composeColor
import ui.utils.snappierModifier

class SnappierButtonComponent : SnappierComponent {
    override val id = "snappier_button"

    @Composable
    override fun render(data: SnappierComponentData) {
        data.contents.firstOrNull()?.let { content ->
            val button = content.buttons.firstOrNull() ?: ButtonData()
            val border = button.border
            val stroke = button.stroke
            Button(
                modifier = Modifier.snappierModifier(content, button.constraints),
                onClick = { },
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
    }
}
