package br.com.androidvip.snappier.domain.component

import androidx.compose.runtime.Composable

/**
 * Base interface for components.
 * Custom components must implement this interface and arrange themselves using the provided
 * [Element] in the [View] function.
 * A Component must have its own unique [id] that is registered by the renderer.
 *
 * @see [SnappierComponentRegisterer]
 */
interface SnappierComponent {
    val id: String

    /**
     * Individual render function for a component.
     * Implementations must use the contents of [data] to render
     * themselves in their particular way using Jetpack Compose [Composable]s
     *
     * @param data Component data with which UI is based
     * @param extras Extra component data, usually filled with parameters from other components.
     *
     * @see <a href="https://developer.android.com/jetpack/compose">Jetpack Compose</a>
     **/
    @Composable
    fun View(data: Element, extras: Map<String, Any?>?)
}
