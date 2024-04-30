package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class VideoDTO(
    val url: String,
    val description: String? = null,
    val resourceName: String? = null,
    val autoPlay: Boolean = false,
    val hideControls: Boolean = false,
    val events: List<EventDTO> = emptyList(),
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
