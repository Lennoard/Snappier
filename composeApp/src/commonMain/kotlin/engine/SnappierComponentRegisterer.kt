package engine

/**
 * In-memory control of components.
 * All components used in a project mut be registered using the [register]
 * function with their own *unique* id.
 *
 * Component registration must occur before any call to [SnappierComponent.render] occurs.
 *
 * Non-registered components will not be rendered by default.
 */
internal object SnappierComponentRegisterer {
    private val registeredComponents: LinkedHashMap<String, SnappierComponent> = linkedMapOf()

    /**
     * Registers a component for the snappier engine.
     * The engine will only render registered components.
     *
     * @param component Component to be registered
     */
    fun register(component: SnappierComponent) {
        registeredComponents[component.id] = component
    }

    /**
     * Gets the [SnappierComponent] associated with an [id].
     * @param id String identifier for a specific [SnappierComponent]
     * @return the [SnappierComponent] associated with the [id] or `null` if none is found.
     * @see [SnappierComponent.id]
     */
    operator fun get(id: String): SnappierComponent? {
        return registeredComponents[id]
    }
}
