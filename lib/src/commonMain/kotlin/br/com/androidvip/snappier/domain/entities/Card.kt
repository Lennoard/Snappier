package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.scaffold.Shadow

interface Card {
    val content: Content
    val backgroundColor: String
    val shadow: Shadow?
    val stroke: Stroke?
    val border: Border?
    val events: List<Event>
    val constraints: Constraints?
    val alignment: String?
}
