package br.com.androidvip.snappier.domain.entities

interface Video : PlaceableUiElement {
    val url: String
    val description: String?
    val resourceName: String?
    val autoPlay: Boolean
    val hideControls: Boolean
}
