package br.com.androidvip.snappier.ui.component

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
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.data.CardData
import br.com.androidvip.snappier.ui.utils.composeColor

class SnappierCardComponent : SnappierObservableComponent("snappier_card") {

    @Composable
    override fun render(data: SnappierComponentData, extras: Map<String, Any?>?) {
        data.contents.firstOrNull()?.let { content ->
            val card = content.cards?.firstOrNull() ?: CardData(Content())
            val cardContent = card.content
            val border = card.border
            val stroke = card.stroke

            OutlinedCard(
                onClick = {
                    content.events?.find { it.trigger == EventTrigger.OnClick }?.let { event ->
                        emmitEvent(event)
                    }
                },
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
                    cardContent.images?.firstOrNull()?.let { imageData ->
                        SnappierImage(imageData)
                    }

                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        cardContent.texts?.forEach { textData ->
                            SnappierText(null, textData)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            cardContent.buttons?.forEach { buttonData ->
                                SnappierButton(
                                    onClick = {
                                        buttonData.events.find {
                                            it.trigger == EventTrigger.OnClick
                                        }?.let { event ->
                                            emmitEvent(event)
                                        }
                                    },
                                    content = null,
                                    button = buttonData
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
