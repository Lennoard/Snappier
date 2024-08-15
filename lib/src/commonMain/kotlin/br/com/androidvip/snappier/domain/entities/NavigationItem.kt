package br.com.androidvip.snappier.domain.entities

import br.com.androidvip.snappier.domain.component.base.Action

interface NavigationItem {
    val action: Action?
    val label: String?
    val enabled: Boolean
    val icon: Icon?
    val color: String?
}
