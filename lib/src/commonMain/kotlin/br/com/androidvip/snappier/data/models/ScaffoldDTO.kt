package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.scaffold.Scaffold
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ScaffoldDTO(
    override val topBar: TopBarDTO? = null,
    override val bottomBar: BottomBarDTO? = null,
    override val floatingElement: ElementDTO? = null,
    override val isNavigationDrawerLayout: Boolean = false,
    override val navigationItems: List<NavigationItemDTO>? = null,
    override val parameters: JsonObject? = null,
    override val elements: List<ElementDTO>? = null
) : Scaffold
