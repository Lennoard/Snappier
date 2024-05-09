package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class IconDTO(
    val token: String = "",
    val size: Float = 24F,
    val color: String = "#000000",
    val events: List<EventDTO> = emptyList(),
    val description: String? = null,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
