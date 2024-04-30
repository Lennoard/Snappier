package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class BorderDTO(
    val topLeft: Float = 0F,
    val topRight: Float = 0F,
    val bottomRight: Float = 0F,
    val bottomLeft: Float = 0F,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
