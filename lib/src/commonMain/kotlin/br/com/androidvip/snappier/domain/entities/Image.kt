package br.com.androidvip.snappier.domain.entities

interface Image : PlaceableUiElement {
    val url: String
    val description: String?
    val resourceName: String?
    val scaleType: String?
    val border: Border?
    val stroke: Stroke?
}
