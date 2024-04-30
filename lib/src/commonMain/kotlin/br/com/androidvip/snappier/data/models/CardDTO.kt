package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CardDTO(
    val content: ContentDTO,
    val backgroundColor: String = "",
    val shadow: ShadowDTO? = null,
    val stroke: StrokeDTO? = null,
    val border: BorderDTO? = null,
    val events: List<EventDTO> = emptyList(),
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
