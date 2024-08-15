package br.com.androidvip.snappier.domain.component.base

import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.component.SnappierComponent
import br.com.androidvip.snappier.domain.component.scaffold.Scaffold
import br.com.androidvip.snappier.domain.component.scaffold.Shadow
import br.com.androidvip.snappier.domain.entities.Border
import br.com.androidvip.snappier.domain.entities.Button
import br.com.androidvip.snappier.domain.entities.Card
import br.com.androidvip.snappier.domain.entities.FloatingActionButton
import br.com.androidvip.snappier.domain.entities.Icon
import br.com.androidvip.snappier.domain.entities.Image
import br.com.androidvip.snappier.domain.entities.Stroke
import br.com.androidvip.snappier.domain.entities.Text
import br.com.androidvip.snappier.domain.entities.Video
import kotlinx.serialization.json.JsonObject

/**
 * A [SnappierComponent]'s content. Any component can be reasonably
 * rendered using this interface's properties as data.
 *
 * @see [Component]
 */
interface Content {
    val description: String?
    val backgroundColor: String?
    val foregroundColor: String?
    val scaffold: Scaffold?
    val stroke: Stroke?
    val shadow: Shadow?
    val border: Border?
    val constraints: Constraints?
    val fab: FloatingActionButton?
    val parameters: JsonObject?
    val images: List<Image>?
    val videos: List<Video>?
    val texts: List<Text>?
    val buttons: List<Button>?
    val icons: List<Icon>?
    val cards: List<Card>?
    val events: List<Event>?
}
