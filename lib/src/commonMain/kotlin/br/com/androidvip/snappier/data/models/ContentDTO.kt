package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.base.Content
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ContentDTO(
    override val description: String? = null,
    override val backgroundColor: String? = null,
    override val foregroundColor: String? = null,
    override val scaffold: ScaffoldDTO? = null,
    override val stroke: StrokeDTO? = null,
    override val shadow: ShadowDTO? = null,
    override val border: BorderDTO? = null,
    override val constraints: ConstraintsDTO? = null,
    override val fab: FloatingActionButtonDTO? = null,
    override val parameters: JsonObject? = null,
    override val images: List<ImageDTO>? = null,
    override val videos: List<VideoDTO>? = null,
    override val texts: List<TextDTO>? = null,
    override val buttons: List<ButtonDTO>? = null,
    override val icons: List<IconDTO>? = null,
    override val cards: List<CardDTO>? = null,
    override val events: List<EventDTO>? = null
) : Content
