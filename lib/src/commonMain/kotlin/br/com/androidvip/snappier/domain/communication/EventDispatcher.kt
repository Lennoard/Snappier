package br.com.androidvip.snappier.domain.communication

import br.com.androidvip.snappier.domain.component.base.SnappierEvent

interface EventDispatcher {
    fun emmitEvent(event: SnappierEvent)
    fun attachObserver(observer: EventObserver)
    fun detachObserver(observer: EventObserver)
}
