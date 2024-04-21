package engine.communication

import component.base.Event

/**
 * Interface for objects interested in receiving events from components.
 * This is the counterpart of [EventDispatcher] and is the middle-ground
 * of component-to-component communication.
 */
fun interface EventObserver {

    /**
     * Called after the component sends events to this observer.
     * @param event [Event] sent.
     */
    fun receiveEvent(event: Event)
}
