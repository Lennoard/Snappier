package engine

import component.base.Event

fun interface EventObserver {
    fun receiveEvent(event: Event)
}
