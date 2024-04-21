package engine

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import component.base.Component
import component.base.Event
import engine.communication.CommunicationReceiver
import engine.communication.Communicator
import engine.communication.EventDispatcher
import engine.communication.EventObserver

class Snappier : EventObserver {
    private val registerer by lazy { SnappierComponentRegisterer }

    var customObserver: EventObserver? = null

    @Composable
    fun draw(component: Component) {
        val registeredComponent = registerer[component.id]
        var extras by remember { mutableStateOf<Map<String, Any?>?>(null) }

        if (registeredComponent is EventDispatcher) {
            DisposableEffect(true) {
                registeredComponent.attachObserver(this@Snappier)
                onDispose {
                    registeredComponent.detachObserver(this@Snappier)
                }
            }
        }

        if (registeredComponent is Communicator) {
            val receiver = CommunicationReceiver { data, targetComponentIds ->
                val registeredComponents = registerer.getAll()
                registeredComponents.forEach {
                    if (it.id in targetComponentIds.orEmpty()) {
                        extras = data
                    }
                }
            }
            DisposableEffect(true) {
                registeredComponent.attachReceiver(receiver)
                onDispose {
                    registeredComponent.detachReceiver(receiver)
                }
            }
        }

        registeredComponent?.render(component, extras)
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
