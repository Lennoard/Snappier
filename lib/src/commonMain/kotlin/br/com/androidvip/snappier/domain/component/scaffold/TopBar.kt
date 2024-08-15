package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.entities.Icon
import br.com.androidvip.snappier.domain.entities.Text

interface TopBar {
    val title: Text?
    val backgroundColor: String?
    val navigationIcon: Icon?
    val icons: List<Icon>?
    val constraints: Constraints?
    val alignment: String?
}
