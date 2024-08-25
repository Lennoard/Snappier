package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Element

interface Scaffold {
    val topBar: TopBar?
    val bottomBar: BottomBar?
    val floatingElement: Element?
    val isNavigationDrawerLayout: Boolean
    val navigationItems: List<NavigationItem>?
    val parameters: Map<String, Any>?
    val elements: List<Element>?
}