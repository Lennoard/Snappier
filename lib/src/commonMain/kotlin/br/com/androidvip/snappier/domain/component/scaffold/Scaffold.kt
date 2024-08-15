package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.entities.NavigationItem
import kotlinx.serialization.json.JsonObject

interface Scaffold {
    val topBar: TopBar?
    val bottomBar: BottomBar?
    val floatingComponent: Component?
    val isNavigationDrawerLayout: Boolean
    val navigationItems: List<NavigationItem>?
    val parameters: JsonObject?
    val components: List<Component>?
}