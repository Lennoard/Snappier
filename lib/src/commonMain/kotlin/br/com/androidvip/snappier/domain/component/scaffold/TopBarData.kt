package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.data.BaseComponentData
import br.com.androidvip.snappier.domain.component.data.IconData
import br.com.androidvip.snappier.domain.component.data.TextData

data class TopBarData(
    val title: TextData?,
    val backgroundColor: String,
    val navigationIcon: IconData?,
    val icons: List<IconData>?
) : BaseComponentData()
