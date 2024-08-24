package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Action
import br.com.androidvip.snappier.domain.entities.Icon

interface NavigationItem {
    val action: Action?
    val label: String?
    val enabled: Boolean
    val icon: Icon?
    val color: String?
}
