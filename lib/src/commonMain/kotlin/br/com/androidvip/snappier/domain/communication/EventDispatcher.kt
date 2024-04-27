package br.com.androidvip.snappier.domain.communication

import br.com.androidvip.snappier.domain.component.base.Event

interface EventDispatcher {
    fun emmitEvent(event: Event)
    fun attachObserver(observer: EventObserver)
    fun detachObserver(observer: EventObserver)
}
