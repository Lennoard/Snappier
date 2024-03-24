package component.base

import engine.SnappierComponent

/**
 * Layout constraints for a [SnappierComponent].
 * Its inclusion/use is optional, the renderer will use default values when this is absent.
 */
data class Constraints(
    val width: Float = 0F,
    val height: Float = 0F,
    val weight: Float = 1F,
)
