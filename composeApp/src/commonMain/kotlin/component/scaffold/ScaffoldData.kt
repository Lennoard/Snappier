package component.scaffold

import component.base.Component
import kotlinx.serialization.json.JsonElement

data class ScaffoldData(
    val topBar: TopBarData? = null,
    val bottomBar: BottomBarData? = null,
    val floatingComponent: Component? = null,
    val isNavigationDrawerLayout: Boolean = false,
    val navigationItems: List<NavigationItem>? = null,
    val parameters: JsonElement? = null,
    val components: List<Component>? = null
)
