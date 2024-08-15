package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event

interface Image {
    val url: String
    val description: String?
    val resourceName: String?
    val scaleType: String?
    val events: List<Event>
    val border: Border?
    val stroke: Stroke?
    val constraints: Constraints?
    val alignment: String?
}
