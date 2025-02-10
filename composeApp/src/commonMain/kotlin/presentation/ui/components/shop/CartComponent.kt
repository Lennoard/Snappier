package presentation.ui.components.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierButton
import br.com.androidvip.snappier.ui.component.SnappierText
import br.com.androidvip.snappier.ui.utils.parse

class CartComponent(observer: EventObserver) : SnappierObservableComponent("cart_screen", observer) {
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(Color.White)
        ) {
            Spacer(modifier = Modifier.padding(32.dp))
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                modifier = Modifier.size(120.dp),
                tint = Color.parse("#88000000")
            )

            Spacer(modifier = Modifier.padding(20.dp))
            data.contents.firstOrNull()?.texts?.forEach { text ->
                SnappierText(content = null, text = text)
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))
            data.contents.firstOrNull()?.buttons?.forEach { button ->
                SnappierButton(
                    onClick = callback@{
                        emmitEvent(button.events.firstOrNull() ?: return@callback)
                    },
                    content = null,
                    button = button
                )
            }
        }
    }
}
