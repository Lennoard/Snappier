package component.base

/**
 * Layout constraints for a [Component].
 * Its inclusion/use is optional, the renderer will use default values when this absent.
 */
data class Constraints(
    val width: Float = 0F,
    val height: Float = 0F,
    val weight: Float = 1F,
)
