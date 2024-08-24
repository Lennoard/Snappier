package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Content

interface Card : PlaceableUiElement {
    val content: Content
    val backgroundColor: String
    val shadow: Shadow?
    val stroke: Stroke?
    val border: Border?
}
