package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event

interface Text {
    val text: String
    val color: String
    val size: Float
    val weight: Int
    val events: List<Event>
    val constraints: Constraints?
    val alignment: String?
}
