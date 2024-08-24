package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.SnappierEvent

interface PlaceableUiElement {
    val events: List<SnappierEvent>
    val constraints: Constraints?
    val alignment: String?
}
