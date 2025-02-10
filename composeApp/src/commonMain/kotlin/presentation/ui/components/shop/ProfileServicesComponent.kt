package presentation.ui.components.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierIconButton
import br.com.androidvip.snappier.ui.component.SnappierText
import br.com.androidvip.snappier.ui.utils.parse

class ProfileServicesComponent : SnappierObservableComponent("services_section") {
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .offset(x = (-16).dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.parse("#dE6054"), Color.Transparent)
                        ),
                        shape = RoundedCornerShape(topEnd = 32.dp)
                    )
            ) {
                data.contents.firstOrNull()?.texts?.firstOrNull()?.let { text ->
                    Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                        SnappierText(content = null, text = text)
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                data.contents.firstOrNull()?.buttons?.forEach { button ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1F)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = ripple(bounded = false),
                                onClick = {}
                            )
                    ) {
                        button.icon?.let { icon ->
                            SnappierIconButton(icon = icon)
                        }
                        Spacer(modifier = Modifier.padding(top = 8.dp))
                        Text(
                            text = button.title,
                            maxLines = 3,
                            style = MaterialTheme.typography.labelLarge,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
