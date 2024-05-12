package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class FloatingActionButtonDTO(
    val color: String? = null,
    val backgroundColor: String? = "#00000000",
    val text: TextDTO? = null,
    val icon: IconDTO? = null,
    val border: BorderDTO? = null,
    val shadow: ShadowDTO? = null,
    val stroke: StrokeDTO? = null,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null,
    val events: List<EventDTO> = emptyList()
)
