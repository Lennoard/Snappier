package engine

import component.base.Event

interface EventCommunicator {
    fun emmitEvent(event: Event)
    fun attachObserver(observer: EventObserver)
    fun detachObserver(observer: EventObserver)
}
