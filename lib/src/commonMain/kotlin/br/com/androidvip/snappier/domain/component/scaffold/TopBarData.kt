package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.ui.component.data.BaseComponentData
import br.com.androidvip.snappier.ui.component.data.IconData
import br.com.androidvip.snappier.ui.component.data.TextData

data class TopBarData(
    val title: TextData? = null,
    val backgroundColor: String? = null,
    val navigationIcon: IconData? = null,
    val icons: List<IconData>? = null
) : BaseComponentData()
