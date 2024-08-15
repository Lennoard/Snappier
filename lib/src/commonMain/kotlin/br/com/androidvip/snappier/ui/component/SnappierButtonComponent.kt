package br.com.androidvip.snappier.ui.component

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
import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.entities.Button
import br.com.androidvip.snappier.ui.utils.composeColor
import br.com.androidvip.snappier.ui.utils.snappierModifier

class SnappierButtonComponent : SnappierObservableComponent(ID) {

    @Composable
    override fun View(data: Component, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            content.buttons?.firstOrNull()?.let { button ->
                SnappierButton(
                    onClick = {
                        content.events?.find { it.trigger == EventTrigger.OnClick }?.let { event ->
                            emmitEvent(event)
                        }
                    },
                    content = content,
                    button = button
                )
            }
        }
    }

    companion object {
        const val ID = "snappier_button"
    }
}

@Composable
fun SnappierButton(onClick: () -> Unit, content: Content?, button: Button) {
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
            if (border.percent != null) {
                RoundedCornerShape(percent = border.percent!!.toInt())
            } else {
                RoundedCornerShape(
                    topStart = border.topLeft,
                    topEnd = border.topRight,
                    bottomStart = border.bottomLeft,
                    bottomEnd = border.bottomRight
                )
            }
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
