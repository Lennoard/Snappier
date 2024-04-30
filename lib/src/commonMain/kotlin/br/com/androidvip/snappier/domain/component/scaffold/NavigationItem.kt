package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Action
import br.com.androidvip.snappier.domain.component.data.IconData

data class NavigationItem(
    val action: Action?,
    val label: String?,
    val enabled: Boolean = true,
    val icon: IconData?,
    val color: String?
)
