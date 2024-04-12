package ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.base.Content
import component.data.CardData
import engine.SnappierComponent
import engine.SnappierComponentData
import ui.utils.composeColor

class SnappierCardComponent : SnappierComponent {
    override val id = "snappier_card"

    @Composable
    override fun render(data: SnappierComponentData) {
        data.contents.firstOrNull()?.let { content ->
            val card = content.cards.firstOrNull() ?: CardData(Content())
            val cardContent = card.content
            val border = card.border
            val stroke = card.stroke

            OutlinedCard(
                onClick = {},
                modifier = Modifier,
                colors = CardDefaults.outlinedCardColors(
                    containerColor = card.backgroundColor.composeColor()
                ),
                elevation = CardDefaults.outlinedCardElevation(
                    defaultElevation = card.shadow?.elevation?.dp ?: 0.dp
                ),
                border = if (stroke != null) {
                    BorderStroke(
                        width = stroke.width.dp,
                        color = stroke.color.composeColor()
                    )
                } else {
                    CardDefaults.outlinedCardBorder()
                },
                shape = if (border != null) {
                    RoundedCornerShape(
                        topStart = border.topLeft,
                        topEnd = border.topRight,
                        bottomStart = border.bottomLeft,
                        bottomEnd = border.bottomRight
                    )
                } else {
                    CardDefaults.outlinedShape
                }
            ) {
                Column {
                    cardContent.images.firstOrNull()?.let { imageData ->
                        SnappierImage(imageData)
                    }

                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        cardContent.texts.forEach { textData ->
                            SnappierText(null, textData)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            cardContent.buttons.forEach { buttonData ->
                                SnappierButton(null, buttonData)
                            }
                        }
                    }
                }
            }
        }
    }
}
