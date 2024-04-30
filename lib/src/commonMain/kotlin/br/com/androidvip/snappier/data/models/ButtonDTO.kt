package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ButtonDTO(
    val color: String = "#FFFFFF",
    val backgroundColor: String = "#000000",
    val title: String = "",
    val border: BorderDTO? = null,
    val shadow: ShadowDTO? = null,
    val stroke: StrokeDTO? = null,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null,
    val events: List<EventDTO> = emptyList()
)
