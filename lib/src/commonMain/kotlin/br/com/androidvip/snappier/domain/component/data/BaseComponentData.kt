package br.com.androidvip.snappier.domain.component.data

import br.com.androidvip.snappier.domain.component.base.Constraints

/**
 * Base class for component data abstractions
 *
 * @param constraints specific [Constraints] this component might have, can be `null` indicating
 * the component will grow to whatever the renderer defaults to.
 * @param alignment specific alignment this component might have, can be `null` indicating
 *  the component aligns itself to whatever the renderer defaults to.
 */
abstract class BaseComponentData(
    open val constraints: Constraints? = null,
    open val alignment: String? = null
)
