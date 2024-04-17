package engine

import androidx.compose.runtime.Composable
import component.base.Event

abstract class SnappierObservableComponent(
    override val id: String,
    defaultObserver: EventObserver? = null
) : SnappierComponent, EventCommunicator {
    private val observers = mutableSetOf<EventObserver>()

    init {
        defaultObserver?.let { attachObserver(it) }
    }

    @Composable
    abstract override fun render(data: SnappierComponentData)

    override fun emmitEvent(event: Event) {
        observers.forEach { observer ->
            observer.receiveEvent(event)
        }
    }

    override fun attachObserver(observer: EventObserver) {
        observers.add(observer)
    }

    override fun detachObserver(observer: EventObserver) {
        observers.remove(observer)
    }
}
