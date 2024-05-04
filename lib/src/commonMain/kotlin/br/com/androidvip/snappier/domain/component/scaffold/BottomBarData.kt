package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.data.BaseComponentData

data class BottomBarData(
    val backgroundColor: String?,
    val iconColor: String?,
    val selectedIconColor: String,
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
