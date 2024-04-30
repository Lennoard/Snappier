package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class StrokeDTO(
    val width: Float = 0F,
    val color: String = "#000000"
)
