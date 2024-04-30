package br.com.androidvip.snappier.domain.component.base

import br.com.androidvip.snappier.domain.component.SnappierComponent
import br.com.androidvip.snappier.domain.component.SnappierComponentData
import br.com.androidvip.snappier.domain.component.data.BorderData
import br.com.androidvip.snappier.domain.component.data.ButtonData
import br.com.androidvip.snappier.domain.component.data.CardData
import br.com.androidvip.snappier.domain.component.data.IconData
import br.com.androidvip.snappier.domain.component.data.ImageData
import br.com.androidvip.snappier.domain.component.data.ShadowData
import br.com.androidvip.snappier.domain.component.data.StrokeData
import br.com.androidvip.snappier.domain.component.data.TextData
import br.com.androidvip.snappier.domain.component.data.VideoData
import br.com.androidvip.snappier.domain.component.scaffold.ScaffoldData
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject

/**
 * A [SnappierComponent]'s content. Any component can be reasonably
 * rendered using this class' properties as data.
 *
 * @see [SnappierComponentData]
 */
data class Content(
    val description: String? = null,
    val backgroundColor: String? = null,
    val foregroundColor: String? = null,
    val scaffold: ScaffoldData? = null,
    val stroke: StrokeData? = null,
    val shadow: ShadowData? = null,
    val border: BorderData? = null,
    val constraints: Constraints? = null,
    val parameters: JsonElement = buildJsonObject { },
    val images: List<ImageData> = emptyList(),
    val videos: List<VideoData> = emptyList(),
    val texts: List<TextData> = emptyList(),
    val buttons: List<ButtonData> = emptyList(),
    val icons: List<IconData> = emptyList(),
    val cards: List<CardData> = emptyList(),
    val events: List<Event> = emptyList()
)
