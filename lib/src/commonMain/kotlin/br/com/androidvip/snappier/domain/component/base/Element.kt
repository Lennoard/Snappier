package br.com.androidvip.snappier.domain.component.base

import br.com.androidvip.snappier.domain.component.SnappierComponent

/**
 * Interface defining an element, the data representation of a [SnappierComponent].
 * Components will use the contents of this to arrange themselves.
 */
interface Element {
    /**
     * Element's unique identifier
     */
    val id: String

    /**
     * The list of [Content]s to be rendered on screen.
     */
    val contents: List<Content>

    /**
     * Optional parameters needed for the behaviour and/or rendering of
     * the [SnappierComponent] associated with this data.
     */
    val parameters: Map<String, Any>?
}
