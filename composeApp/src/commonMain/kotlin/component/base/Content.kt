package component.base

import component.data.BorderData
import component.data.ButtonData
import component.data.CardData
import component.data.IconData
import component.data.ImageData
import component.data.ShadowData
import component.data.StrokeData
import component.data.TextData
import component.data.VideoData
import engine.SnappierComponent
import engine.SnappierComponentData
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject

/**
 * A [SnappierComponent]'s content. Any component can be reasonably
 * rendered using this class' properties as data.
 *
 * This class is the entry point of the serialized "component" JSON.
 *
 * @see [SnappierComponentData]
 */
data class Content(
    val description: String? = null,
    val backgroundColor: String? = null,
    val foregroundColor: String? = null,
    val stroke: StrokeData? = null,
    val shadow: ShadowData? = null,
    val border: BorderData? = null,
    val constraints: List<Constraints> = emptyList(),
    val parameters: JsonElement = buildJsonObject { },
    val images: List<ImageData> = emptyList(),
    val videos: List<VideoData> = emptyList(),
    val texts: List<TextData> = emptyList(),
    val buttons: List<ButtonData> = emptyList(),
    val icons: List<IconData> = emptyList(),
    val cards: List<CardData> = emptyList(),
)
