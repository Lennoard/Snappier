package engine

import androidx.compose.runtime.Composable
import component.base.Event

abstract class SnappierObservableComponent(
    override val id: String,
    defaultObserver: EventObserver? = null
) : SnappierComponent, EventCommunicator {
    protected val observers = mutableSetOf<EventObserver>()

    init {
        defaultObserver?.let { attachObserver(it) }
    }

    @Composable
    abstract override fun render(data: SnappierComponentData)

    final override fun emmitEvent(event: Event) {
        observers.forEach { observer ->
            observer.receiveEvent(event)
        }
    }

    final override fun attachObserver(observer: EventObserver) {
        observers.add(observer)
    }

    final override fun detachObserver(observer: EventObserver) {
        observers.remove(observer)
    }
}
