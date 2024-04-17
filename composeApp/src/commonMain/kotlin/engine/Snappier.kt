package engine

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import component.base.Component
import component.base.Event

class Snappier : EventObserver {
    private val registerer by lazy { SnappierComponentRegisterer }

    var customObserver: EventObserver? = null

    @Composable
    fun draw(component: Component) {
        val registeredComponent = registerer[component.id]

        if (registeredComponent is EventCommunicator) {
            DisposableEffect(true) {
                registeredComponent.attachObserver(this@Snappier)
                onDispose {
                    registeredComponent.detachObserver(this@Snappier)
                }
            }
        }
        registeredComponent?.render(component)
    }

    @Composable
    fun draw(components: List<Component>) {
        LazyColumn {
            items(count = components.count()) { index ->
                draw(components[index])
            }
        }
    }

    fun register(components: List<SnappierComponent>) {
        components.forEach(::register)
    }

    fun register(component: SnappierComponent) {
        registerer.register(component)
    }

    override fun receiveEvent(event: Event) {
        if (customObserver != null) {
            customObserver?.receiveEvent(event)
        } else {
            // TODO: Call navigator
        }
    }
}
