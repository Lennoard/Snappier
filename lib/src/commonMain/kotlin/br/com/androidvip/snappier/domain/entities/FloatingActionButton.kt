package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.scaffold.Shadow

interface FloatingActionButton {
    val color: String?
    val backgroundColor: String?
    val text: Text?
    val icon: Icon?
    val border: Border?
    val shadow: Shadow?
    val stroke: Stroke?
    val constraints: Constraints?
    val alignment: String?
    val events: List<Event>
}