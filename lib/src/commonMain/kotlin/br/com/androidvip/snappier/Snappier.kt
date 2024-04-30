package br.com.androidvip.snappier

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.androidvip.snappier.domain.communication.CommunicationReceiver
import br.com.androidvip.snappier.domain.communication.Communicator
import br.com.androidvip.snappier.domain.communication.EventDispatcher
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.component.SnappierComponent
import br.com.androidvip.snappier.domain.component.SnappierComponentRegisterer
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.ui.component.SnappierButtonComponent
import br.com.androidvip.snappier.ui.component.SnappierCardComponent
import br.com.androidvip.snappier.ui.component.SnappierIconComponent
import br.com.androidvip.snappier.ui.component.SnappierImageComponent
import br.com.androidvip.snappier.ui.component.SnappierScaffoldComponent
import br.com.androidvip.snappier.ui.component.SnappierTextComponent
import br.com.androidvip.snappier.ui.component.SnappierVideoComponent

class Snappier : EventObserver {
    private val registerer by lazy { SnappierComponentRegisterer }

    var customObserver: EventObserver? = null

    init {
        // Register default/sample components
        register(SnappierButtonComponent())
        register(SnappierScaffoldComponent())
        register(SnappierCardComponent())
        register(SnappierImageComponent())
        register(SnappierTextComponent())
        register(SnappierIconComponent())
        register(SnappierVideoComponent())
    }

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
                // TODO: There may be more than one component rendered with the same ID
                val registeredComponents = SnappierComponentRegisterer.getAll()
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
        SnappierComponentRegisterer.register(component)
    }

    override fun receiveEvent(event: Event) {
        if (customObserver != null) {
            customObserver?.receiveEvent(event)
        } else {
            // TODO: Call navigator
        }
    }
}
