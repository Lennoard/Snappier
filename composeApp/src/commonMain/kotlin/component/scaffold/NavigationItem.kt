package component.scaffold

import component.base.Action
import component.data.IconData

data class NavigationItem(
    val action: Action?,
    val label: String? = null,
    val enabled: Boolean = true,
    val icon: IconData? = null,
    val color: String? = "#000000"
)
