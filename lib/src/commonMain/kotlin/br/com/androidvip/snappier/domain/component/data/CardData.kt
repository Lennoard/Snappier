package br.com.androidvip.snappier.domain.component.data

import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.Event

data class CardData(
    val content: Content,
    val backgroundColor: String = "",
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    val border: BorderData? = null,
    val events: List<Event> = emptyList()
) : BaseComponentData()
