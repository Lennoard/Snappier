package br.com.androidvip.snappier.domain.component

import br.com.androidvip.snappier.domain.component.base.Content
import kotlinx.serialization.json.JsonElement

/**
 * Base interface for component data.
 * Components will use the contents of this to arrange themselves.
 */
interface SnappierComponentData {
    /**
     * The list of [Content]s to be rendered on screen.
     */
    val contents: List<Content>

    /**
     * Optional parameters needed for the behaviour and/or rendering of
     * the [SnappierComponent] associated with this data.
     */
    val parameters: JsonElement?
}
