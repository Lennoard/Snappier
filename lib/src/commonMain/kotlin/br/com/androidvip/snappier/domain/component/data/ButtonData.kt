package br.com.androidvip.snappier.domain.component.data

import br.com.androidvip.snappier.domain.component.base.Event

data class ButtonData(
    val color: String,
    val backgroundColor: String,
    val title: String,
    val border: BorderData? = null,
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    val events: List<Event> = emptyList()
) : BaseComponentData()
