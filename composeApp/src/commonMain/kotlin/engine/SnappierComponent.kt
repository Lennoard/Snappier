package engine

import androidx.compose.runtime.Composable

/**
 * Base interface for components.
 * Custom components must implement this interface and arrange themselves using the provided
 * [ComponentData] in the [ContentRender] function.
 * A Component must have its own unique [id] that is registered by the renderer.
 *
 * @see [ComponentRegisterer]
 */
interface SnappierComponent {
    val id: String

    /**
     * Individual render function for a component.
     * Implementations must use the contents of [data] to render
     * themselves in their particular way using Jetpack Compose [Composable]s
     *
     * @see <a href="https://developer.android.com/jetpack/compose">Jetpack Compose</a>
     **/
    @Composable
    fun ContentRender(data: ComponentData)
}
