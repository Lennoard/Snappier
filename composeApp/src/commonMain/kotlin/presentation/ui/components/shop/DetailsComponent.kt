package presentation.ui.components.shop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.androidvip.snappier.data.models.ActionDTO
import br.com.androidvip.snappier.data.models.EventDTO
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.ActionType
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierButton
import br.com.androidvip.snappier.ui.component.SnappierImage
import br.com.androidvip.snappier.ui.component.SnappierText
import br.com.androidvip.snappier.ui.utils.parse
import data.events.genericEvent

class DetailsComponent(defaultObserver: EventObserver? = null) : SnappierObservableComponent("product_details", defaultObserver) {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        val scrollState = rememberScrollState()

        Box(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            Column {
                Box(modifier = Modifier.fillMaxWidth()) {
                    data.contents.firstOrNull()?.images?.forEach { image ->
                        SnappierImage(image)
                    }

                    var favorite by remember { mutableStateOf(false) }
                    IconButton(
                        onClick = {
                            favorite = !favorite
                            emmitEvent(
                                genericEvent(
                                    ActionDTO(
                                        data = if (!favorite) "Removed" else "Added",
                                        type = ActionType.ShowShortMessage
                                    )
                                )
                            )
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp)
                            .border(1.dp, Color.Black, CircleShape)
                            .background(
                                color = Color.parse("#88FFFFFF"),
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "",
                            tint = if (favorite) {
                                Color.parse("#dE6054")
                            } else {
                                Color.Black
                            }
                        )
                    }
                }

                AnimatedVisibility(visible = scrollState.value > 700) {
                    Spacer(modifier = Modifier.size(56.dp))
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    data.contents.firstOrNull()?.texts?.forEachIndexed { index, text ->
                        val discount by rememberSaveable { mutableIntStateOf((5..50).random()) }
                        val times by rememberSaveable { mutableIntStateOf((1..7).random()) }
                        val installment by rememberSaveable { mutableIntStateOf((12..269).random()) }

                        when (index) {
                            0 -> {
                                Row(verticalAlignment = Alignment.Bottom) {
                                    SnappierText(null, text)
                                    Spacer(modifier = Modifier.padding(start = 8.dp))
                                    Text(text = "$discount% desc.", color = Color.Red)
                                }
                                Text(text = "${times}x $installment com juros")
                                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                            }

                            2 -> {
                                Spacer(modifier = Modifier.padding(top = 24.dp))
                                Text(text = "Informações gerais:", fontWeight = FontWeight.SemiBold)
                                SnappierText(null, text)
                            }

                            else -> {
                                SnappierText(null, text)
                            }
                        }
                    }


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                            .offset(x = (-16).dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.parse("#dE6054"),
                                        Color.Transparent
                                    )
                                ),
                                shape = RoundedCornerShape(
                                    topEnd = 32.dp
                                )
                            )
                    ) {
                        Text(
                            text = "Shop commitment",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    Text(
                        text = "Warranty",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.alpha(0.6F)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = "",
                            modifier = Modifier.size(16.dp),
                            tint = Color.parse("#428A29")
                        )
                        Text(
                            text = "$15.00 discount",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.alpha(0.6F)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = "",
                            modifier = Modifier.size(16.dp),
                            tint = Color.parse("#428A29")
                        )
                        Text(
                            text = "7 day money back guarantee",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(vertical = 32.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        data.contents.firstOrNull()?.buttons?.forEach { button ->
                            SnappierButton(
                                onClick = callback@{
                                    emmitEvent(button.events.firstOrNull() ?: return@callback)
                                },
                                null,
                                button,
                            )
                        }
                    }
                }
            }

            TopAppBar(
                title = { },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            emmitEvent(genericEvent(ActionDTO(type = ActionType.NavigateUp)))
                        },
                        modifier = Modifier
                            .border(1.dp, Color.Black, CircleShape)
                            .background(
                                color = Color.parse("#88FFFFFF"),
                                shape = CircleShape
                            )
                    ) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, "")
                    }
                }
            )
        }
    }
}
