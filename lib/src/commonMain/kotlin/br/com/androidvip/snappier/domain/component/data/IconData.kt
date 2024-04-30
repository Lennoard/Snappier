package br.com.androidvip.snappier.domain.component.data

import br.com.androidvip.snappier.domain.component.base.Event

data class IconData(
    val size: Float,
    val token: String,
    val color: String,
    val events: List<Event> = emptyList(),
    val description: String? = null
) : BaseComponentData()
