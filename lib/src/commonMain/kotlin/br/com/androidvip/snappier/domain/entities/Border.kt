package br.com.androidvip.snappier.domain.entities

interface Border {
    val topLeft: Float
    val topRight: Float
    val bottomRight: Float
    val bottomLeft: Float
    val percent: Float?
}
