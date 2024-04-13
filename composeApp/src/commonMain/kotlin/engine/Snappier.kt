package engine

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import component.base.Component

class Snappier {
    private val registerer by lazy { SnappierComponentRegisterer }

    @Composable
    fun draw(component: Component) {
        val registeredComponent = registerer[component.id]
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
}
