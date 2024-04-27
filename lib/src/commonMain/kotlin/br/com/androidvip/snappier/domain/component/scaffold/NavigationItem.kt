package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Action
import br.com.androidvip.snappier.ui.component.data.IconData

data class NavigationItem(
    val action: Action?,
    val label: String? = null,
    val enabled: Boolean = true,
    val icon: IconData? = null,
    val color: String? = "#000000"
)
