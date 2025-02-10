package presentation.ui.components.shop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierImage
import br.com.androidvip.snappier.ui.component.SnappierText
import br.com.androidvip.snappier.ui.utils.composeColor
import br.com.androidvip.snappier.ui.utils.snappierModifier
import br.com.androidvip.snappier.ui.utils.textAlignment
import presentation.ui.utils.getScreenWidth

class RecommendedComponent : SnappierObservableComponent("recommended") {
    @OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        val screenWidth = getScreenWidth()

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            data.contents.firstOrNull()?.let { content ->
                Row(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 24.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    content.texts?.firstOrNull()?.let { text ->
                        SnappierText(content = content, text = text)
                        Spacer(modifier = Modifier.weight(1F))
                    }
                    content.buttons?.firstOrNull()?.let { button ->
                        TextButton(
                            onClick = callback@ {
                                emmitEvent(button.events.firstOrNull() ?: return@callback)
                            }
                        ) {
                            Text(text = button.title)
                            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "")
                        }
                    }
                }
            }

            val factor by remember {
                mutableIntStateOf(if (screenWidth > 720) 4 else 3)
            }

            FlowRow(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                val cardWidth = ((screenWidth / factor) - 16).dp
                data.contents.lastOrNull()?.cards?.let { cards ->
                    cards.forEach { cardData ->
                        val stroke = cardData.stroke
                        OutlinedCard(
                            onClick = callback@ {
                                emmitEvent(cardData.events.firstOrNull() ?: return@callback)
                            },
                            modifier = Modifier
                                .padding(4.dp)
                                .width(cardWidth),
                            border =
                            if (stroke != null) {
                                BorderStroke(
                                    width = stroke.width.dp,
                                    color = stroke.color.composeColor(),
                                )
                            } else {
                                CardDefaults.outlinedCardBorder()
                            },
                        ) {
                            cardData.content.images?.firstOrNull()?.let { image ->
                                SnappierImage(image)
                            }
                            Column(modifier = Modifier.padding(8.dp)) {
                                cardData.content.texts?.forEach { text ->
                                    Text(
                                        text = text.text,
                                        color = text.color.composeColor(),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = text.size.sp,
                                        textAlign = text.alignment.textAlignment(),
                                        fontWeight = FontWeight(text.fontWeight),
                                        modifier =
                                        Modifier.snappierModifier(
                                            content = cardData.content,
                                            constraints = text.constraints,
                                        ),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
