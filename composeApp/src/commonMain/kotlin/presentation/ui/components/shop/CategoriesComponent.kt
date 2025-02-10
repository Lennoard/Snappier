package presentation.ui.components.shop

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element

class CategoriesComponent : SnappierObservableComponent("categories") {
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        LazyRow(modifier = Modifier.padding(vertical = 16.dp)) {
            data.contents.firstOrNull()?.texts?.let { texts ->
                itemsIndexed(texts) { index, textData ->
                    SuggestionChip(
                        onClick = { },
                        label = { Text(textData.text) },
                        modifier =
                        Modifier.padding(
                            start = 16.dp,
                            end = if (index == texts.lastIndex) 16.dp else 0.dp,
                        ),
                    )
                }
            }
        }
    }
}
