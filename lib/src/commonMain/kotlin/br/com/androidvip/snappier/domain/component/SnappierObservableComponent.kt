package br.com.androidvip.snappier.domain.component

import androidx.compose.runtime.Composable
import br.com.androidvip.snappier.domain.communication.CommunicationReceiver
import br.com.androidvip.snappier.domain.communication.Communicator
import br.com.androidvip.snappier.domain.communication.EventDispatcher
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.base.Event

abstract class SnappierObservableComponent(
    override val id: String,
    defaultObserver: EventObserver? = null
) : SnappierComponent, EventDispatcher, Communicator {
    protected val observers = mutableSetOf<EventObserver>()
    protected val receivers = mutableSetOf<CommunicationReceiver>()

    init {
        defaultObserver?.let { attachObserver(it) }
    }

    @Composable
    abstract override fun render(data: SnappierComponentData, extras: Map<String, Any?>?)

    final override fun emmitEvent(event: Event) {
        observers.forEach { observer ->
            observer.receiveEvent(event)
        }
    }

    final override fun communicateData(data: Map<String, Any?>, targetComponentIds: List<String>?) {
        receivers.forEach { receiver ->
            receiver.receiveCommunication(data, targetComponentIds)
        }
    }

    final override fun attachReceiver(receiver: CommunicationReceiver) {
        receivers.add(receiver)
    }

    final override fun attachObserver(observer: EventObserver) {
        observers.add(observer)
    }

    final override fun detachObserver(observer: EventObserver) {
        observers.remove(observer)
    }

    final override fun detachReceiver(receiver: CommunicationReceiver) {
        receivers.remove(receiver)
    }
}
