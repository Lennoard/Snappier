package presentation.ui.components.shop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.androidvip.snappier.data.models.ActionDTO
import br.com.androidvip.snappier.data.models.ConstraintsDTO
import br.com.androidvip.snappier.data.models.ImageDTO
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.SnappierObservableComponent
import br.com.androidvip.snappier.domain.component.base.ActionType
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.ui.component.SnappierImage
import data.events.genericEvent
import presentation.ui.utils.getScreenWidth

class SearchComponent(observer: EventObserver) :
    SnappierObservableComponent("shop-search", observer) {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    @Composable
    override fun View(data: Element, extras: Map<String, Any?>?) {
        val screenWidth = getScreenWidth()
        var searchActive by remember { mutableStateOf(false) }
        var searching by remember { mutableStateOf(false) }
        var cards by remember { mutableStateOf(data.contents.lastOrNull()?.cards.orEmpty()) }
        var query by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                val colors1 = SearchBarDefaults.colors()
                SearchBar(
                    inputField = {
                        SearchBarDefaults.InputField(
                            query = query,
                            onQueryChange = { query = it; searching = false },
                            onSearch = {
                                searching = true
                                cards = data.contents.lastOrNull()?.cards.orEmpty().filter {
                                    it.content.texts?.getOrNull(2)?.text?.contains(
                                        query.trim(),
                                        true
                                    ) == true
                                }
                            },
                            expanded = searchActive,
                            onExpandedChange = { searchActive = it },
                            enabled = true,
                            placeholder = { Text("Pesquisar produtos...") },
                            leadingIcon = null,
                            trailingIcon = null,
                            colors = colors1.inputFieldColors,
                            interactionSource = null,
                        )
                    },
                    expanded = searchActive,
                    onExpandedChange = { searchActive = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = SearchBarDefaults.inputFieldShape,
                    colors = colors1,
                    tonalElevation = SearchBarDefaults.TonalElevation,
                    shadowElevation = SearchBarDefaults.ShadowElevation,
                    windowInsets = SearchBarDefaults.windowInsets,
                    content = {
                        Spacer(modifier = Modifier.padding(top = 16.dp))
                        LazyColumn {
                            item {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = {
                                            emmitEvent(
                                                genericEvent(ActionDTO(type = ActionType.NavigateUp))
                                            )
                                        },
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = "Voltar"
                                        )
                                    }
                                    AnimatedVisibility(searching && query.isNotBlank()) {
                                        Text(
                                            text = "Resultados para: $query",
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(16.dp)
                                        )
                                    }
                                }
                            }
                            items(cards.size) { index ->
                                val card = cards[index]
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable callback@{
                                            emmitEvent(card.events.firstOrNull() ?: return@callback)
                                        }
                                ) {
                                    Text(
                                        text = card.content.texts?.getOrNull(2)?.text.orEmpty(),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .weight(1F)
                                    )

                                    card.content.images?.firstOrNull()?.let { image ->
                                        Box(modifier = Modifier.size(48.dp).padding(end = 16.dp)) {
                                            SnappierImage(
                                                (image as? ImageDTO)?.copy(
                                                    alignment = "end",
                                                    constraints = ConstraintsDTO(
                                                        width = -1F,
                                                        height = -1F,
                                                        weight = 0F
                                                    )
                                                ) ?: image
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    },
                )
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(paddingValues = it).fillMaxWidth()
            ) {
                val factor by remember {
                    mutableIntStateOf(if (screenWidth > 720) 4 else 3)
                }

                FlowRow(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .verticalScroll(rememberScrollState())
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    val cardWidth = ((screenWidth / factor) - 16).dp
                    cards.forEach { cardData ->
                        ProductCard(
                            cardData = cardData,
                            cardWidth = cardWidth,
                            onClick = callback@{
                                emmitEvent(cardData.events.firstOrNull() ?: return@callback)
                            }
                        )
                    }
                }
            }
        }
    }
}
