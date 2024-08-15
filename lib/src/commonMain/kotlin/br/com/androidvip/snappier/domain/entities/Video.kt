package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event

interface Video {
    val url: String
    val description: String?
    val resourceName: String?
    val autoPlay: Boolean
    val hideControls: Boolean
    val events: List<Event>
    val constraints: Constraints?
    val alignment: String?
}
