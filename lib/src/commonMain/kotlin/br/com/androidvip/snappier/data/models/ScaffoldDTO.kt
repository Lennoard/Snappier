package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ScaffoldDTO(
    val topBar: TopBarDTO? = null,
    val bottomBar: BottomBarDTO? = null,
    val floatingComponent: ComponentDTO? = null,
    val isNavigationDrawerLayout: Boolean = false,
    val navigationItems: List<NavigationItemDTO>? = null,
    val parameters: JsonElement? = null,
    val components: List<ComponentDTO>? = null
)
