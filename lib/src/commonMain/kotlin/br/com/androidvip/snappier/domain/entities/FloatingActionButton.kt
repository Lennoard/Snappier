package br.com.androidvip.snappier.domain.entities

interface FloatingActionButton : PlaceableUiElement {
    val color: String?
    val backgroundColor: String?
    val text: Text?
    val icon: Icon?
    val border: Border?
    val shadow: Shadow?
    val stroke: Stroke?
}
