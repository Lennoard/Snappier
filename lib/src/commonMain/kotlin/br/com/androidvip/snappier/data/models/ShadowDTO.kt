package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ShadowDTO(
    val elevation: Float = 0F,
    val color: String = "#000000",
    val constraints: ConstraintsDTO? = null
)
