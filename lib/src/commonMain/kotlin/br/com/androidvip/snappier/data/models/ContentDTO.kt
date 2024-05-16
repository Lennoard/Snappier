package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

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
    val fab: FloatingActionButtonDTO? = null,
    val parameters: JsonObject? = null,
    val images: List<ImageDTO>? = null,
    val videos: List<VideoDTO>? = null,
    val texts: List<TextDTO>? = null,
    val buttons: List<ButtonDTO>? = null,
    val icons: List<IconDTO>? = null,
    val cards: List<CardDTO>? = null,
    val events: List<EventDTO>? = null
)
