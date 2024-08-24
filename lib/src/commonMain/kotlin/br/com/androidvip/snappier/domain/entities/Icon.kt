package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.SnappierEvent

interface Icon : PlaceableUiElement {
    val token: String
    val size: Float
    val color: String
    val description: String?

    fun copyEvents(icon: Icon, events: List<SnappierEvent>): Icon {
        return object : Icon {
            override val token = icon.token
            override val size = icon.size
            override val color = icon.color
            override val events = events
            override val description = icon.description
            override val constraints = icon.constraints
            override val alignment = icon.alignment
        }
    }
}
