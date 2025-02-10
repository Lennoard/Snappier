package presentation.ui.components.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import presentation.ui.utils.getScreenWidth

class FeaturedAllComponent : SnappierObservableComponent("featured_all") {
    @OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        val screenWidth = getScreenWidth()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {

            val factor by remember {
                mutableIntStateOf(if (screenWidth > 720) 4 else 3)
            }

            FlowRow(modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth()) {
                val cardWidth = ((screenWidth / factor) - 16).dp
                data.contents.lastOrNull()?.cards?.shuffled()?.let { cards ->
                    cards.forEach { cardData ->
                        ProductCard(
                            cardData = cardData,
                            cardWidth = cardWidth,
                            onClick = callback@ {
                                emmitEvent(cardData.events.firstOrNull() ?: return@callback)
                            }
                        )
                    }
                }
            }
        }
    }
}
