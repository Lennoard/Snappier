package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject

@Serializable
data class ContentDTO(
    val description: String? = null,
    val backgroundColor: String? = null,
    val foregroundColor: String? = null,
    val scaffold: ScaffoldDTO? = null,
    val stroke: StrokeDTO? = null,
    val shadow: ShadowDTO? = null,
    val border: BorderDTO? = null,
    val constraints: ConstraintsDTO? = null,
    val parameters: JsonElement = buildJsonObject { },
    val images: List<ImageDTO> = emptyList(),
    val videos: List<VideoDTO> = emptyList(),
    val texts: List<TextDTO> = emptyList(),
    val buttons: List<ButtonDTO> = emptyList(),
    val icons: List<IconDTO> = emptyList(),
    val cards: List<CardDTO> = emptyList(),
    val events: List<EventDTO> = emptyList()
)
