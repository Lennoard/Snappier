package engine

import androidx.compose.runtime.Composable
import component.base.Event
import engine.communication.CommunicationReceiver
import engine.communication.Communicator
import engine.communication.EventDispatcher
import engine.communication.EventObserver

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
