package engine.communication

import component.base.Event

interface EventDispatcher {
    fun emmitEvent(event: Event)
    fun attachObserver(observer: EventObserver)
    fun detachObserver(observer: EventObserver)
}
