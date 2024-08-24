package br.com.androidvip.snappier.domain.entities

interface Text : PlaceableUiElement {
    val text: String
    val color: String
    val size: Float
    val fontWeight: Int
}
