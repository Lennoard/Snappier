package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Constraints

interface BottomBar {
    val backgroundColor: String?
    val iconColor: String?
    val selectedIconColor: String?
    val constraints: Constraints?
    val alignment: String?
}
