package component.scaffold

import component.data.BaseComponentData
import component.data.IconData
import component.data.TextData

data class TopBarData(
    val title: TextData? = null,
    val backgroundColor: String? = null,
    val navigationIcon: IconData? = null,
    val icons: List<IconData>? = null
) : BaseComponentData()
