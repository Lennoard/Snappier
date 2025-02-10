package presentation.ui.components.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierImage
import br.com.androidvip.snappier.ui.component.SnappierText

class ProfileHeaderComponent : SnappierObservableComponent("my_profile_header") {
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            data.contents.firstOrNull()?.images?.firstOrNull()?.let { image ->
                Spacer(modifier = Modifier.padding(16.dp))
                SnappierImage(image = image)
            }

            data.contents.firstOrNull()?.texts?.firstOrNull()?.let { text ->
                Spacer(modifier = Modifier.padding(8.dp))
                SnappierText(null, text)
            }
        }
    }
}
