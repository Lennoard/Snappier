package presentation.ui.components.social

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.androidvip.snappier.data.models.IconDTO
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierIconButton
import br.com.androidvip.snappier.ui.utils.composeColor

class SocialTabComponent : SnappierObservableComponent("social-tab") {
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val bgColor = data.contents.firstOrNull()?.backgroundColor.composeColor()
        val fgColor = data.contents.firstOrNull()?.foregroundColor.composeColor()

        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = bgColor,
            contentColor = fgColor,
            modifier = Modifier.fillMaxWidth(),
            indicator = { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = fgColor
                    )
                }
            }
        ) {
            data.contents.firstOrNull()?.icons?.forEachIndexed { index, icon ->
                val selected = index == selectedTabIndex
                val colorMatchedIcon = (icon as? IconDTO)?.copy(
                    color = if (selected) {
                        data.contents.firstOrNull()?.foregroundColor
                    } else {
                        icon.color
                    } ?: icon.color
                ) ?: icon
                Tab(
                    selected = selected,
                    onClick = callback@ {
                        selectedTabIndex = index
                        emmitEvent(icon.events.firstOrNull() ?: return@callback)
                    },
                    icon = { SnappierIconButton(icon = colorMatchedIcon, null) },
                    selectedContentColor = fgColor,
                    unselectedContentColor = colorMatchedIcon.color.composeColor()
                )
            }
        }
    }
}
