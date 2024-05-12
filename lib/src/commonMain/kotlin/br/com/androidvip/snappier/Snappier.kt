package br.com.androidvip.snappier

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.androidvip.snappier.config.SnappierConfig
import br.com.androidvip.snappier.data.mappers.ComponentMapper
import br.com.androidvip.snappier.data.models.ComponentDTO
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
import br.com.androidvip.snappier.ui.component.SnappierFloatingActionButtonComponent
import br.com.androidvip.snappier.ui.component.SnappierIconComponent
import br.com.androidvip.snappier.ui.component.SnappierImageComponent
import br.com.androidvip.snappier.ui.component.SnappierScaffoldComponent
import br.com.androidvip.snappier.ui.component.SnappierTextComponent
import br.com.androidvip.snappier.ui.component.SnappierVideoComponent
import io.ktor.client.call.body
import io.ktor.client.plugins.onDownload
import io.ktor.client.request.request
import io.ktor.client.request.url

fun Snappier(block: SnappierConfig.() -> Unit): Snappier {
    val config = SnappierConfig().apply(block)
    return Snappier(config)
}

class Snappier(private val config: SnappierConfig = SnappierConfig.defaultConfig) : EventObserver {
    private val registerer by lazy { SnappierComponentRegisterer }

    private val observers = mutableSetOf<EventObserver>()

    init {
        // Register default/sample components
        register(SnappierButtonComponent())
        register(SnappierFloatingActionButtonComponent())
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

    @Composable
    fun draw(url: String) {
        var component by remember { mutableStateOf<Component?>(null) }
        var progress by remember { mutableIntStateOf(0) }
        var loading by remember { mutableStateOf(false) }
        var error by remember { mutableStateOf<Throwable?>(null) }

        LaunchedEffect(true) {
            loading = true
            runCatching {
                val request = config.httpClient.request {
                    method = config.httpMethod
                    url(url)
                    onDownload { bytesSentTotal, contentLength ->
                        progress = ((bytesSentTotal / contentLength) * 100).toInt()
                    }
                }
                val dto = request.body<ComponentDTO>()
                component = ComponentMapper.map(dto)
            }.onFailure {
                error = it
            }
            loading = false
        }

        AnimatedVisibility(loading && config.onLoading != null) {
            config.onLoading?.let { it(progress) }
        }

        AnimatedVisibility(error != null && config.onError != null) {
            config.onError?.let { it(error!!) }
        }

        AnimatedVisibility(!loading && error == null) {
            if (component != null) {
                draw(component!!)
            }
        }
    }

    fun register(components: List<SnappierComponent>) {
        components.forEach(::register)
    }

    fun register(component: SnappierComponent) {
        SnappierComponentRegisterer.register(component)
    }

    fun addObserver(observer: EventObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: EventObserver) {
        observers.remove(observer)
    }

    override fun receiveEvent(event: Event) {
        observers.forEach {
            it.receiveEvent(event)
        }
        // TODO call internal navigator if useNavigator flag is set to true
    }
}
