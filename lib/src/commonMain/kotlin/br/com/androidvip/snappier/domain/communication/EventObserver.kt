package br.com.androidvip.snappier.domain.communication

import br.com.androidvip.snappier.domain.component.base.SnappierEvent

/**
 * Interface for objects interested in receiving events from components.
 * This is the counterpart of [EventDispatcher] and is the middle-ground
 * of component-to-component communication.
 */
fun interface EventObserver {

    /**
     * Called after the component sends events to this observer.
     * @param event [SnappierEvent] sent.
     */
    fun receiveEvent(event: SnappierEvent)
}
