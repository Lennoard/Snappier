package component.data

import component.base.Constraints
import component.base.Event

/**
 * Base class for component data abstractions
 *
 * @param events list of [Event]s this component is interested in, can be empty.
 * @param constraints specific [Constraints] this component might have, can be `null` indicating
 * the component will grow to whatever the renderer defaults to.
 * @param alignment specific alignment this component might have, can be `null` indicating
 *  the component aligns itself to whatever the renderer defaults to.
 */
abstract class ComponentData(
    open val events: List<Event> = emptyList(),
    open val constraints: Constraints? = null,
    open val alignment: String? = null,
)