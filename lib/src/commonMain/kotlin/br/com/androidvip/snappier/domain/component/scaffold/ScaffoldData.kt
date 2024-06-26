package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.Component
import kotlinx.serialization.json.JsonObject

data class ScaffoldData(
    val topBar: TopBarData? = null,
    val bottomBar: BottomBarData? = null,
    val floatingComponent: Component? = null,
    val isNavigationDrawerLayout: Boolean = false,
    val navigationItems: List<NavigationItem>? = null,
    val parameters: JsonObject? = null,
    val components: List<Component>? = null
)
