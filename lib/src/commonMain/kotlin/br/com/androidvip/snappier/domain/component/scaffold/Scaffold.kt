package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Element
import kotlinx.serialization.json.JsonObject

interface Scaffold {
    val topBar: TopBar?
    val bottomBar: BottomBar?
    val floatingElement: Element?
    val isNavigationDrawerLayout: Boolean
    val navigationItems: List<NavigationItem>?
    val parameters: JsonObject?
    val elements: List<Element>?
}