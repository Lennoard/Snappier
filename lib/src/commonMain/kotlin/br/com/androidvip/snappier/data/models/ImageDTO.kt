package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageDTO(
    val url: String = "",
    val description: String? = null,
    val resourceName: String? = null,
    val scaleType: String? = null,
    val events: List<EventDTO> = emptyList(),
    val border: BorderDTO? = null,
    val stroke: StrokeDTO? = null,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
