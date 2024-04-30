package br.com.androidvip.snappier.domain.component.base

/**
 * Optional layout constrains for a component
 */
data class Constraints(
    val width: Float,
    val height: Float,
    val weight: Float
) {
    /**
     * Special constants for [Constraints]
     */
    companion object {
        /**
         * Content should be as tall (or wide) as it gets (within its parent's bounds)
         */
        const val WRAP_CONTENT = 0F

        /**
         * Content should fill all available space (width / height or both)
         */
        const val FILL_MAX = -1F
        const val DEFAULT_WEIGHT = 1F
    }
}
