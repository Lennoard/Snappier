package component.data

import component.base.Content

data class CardData(
    val content: Content,
    val shadow: ShadowData?,
    val stroke: StrokeData?,
    val border: BorderData?,
) : ComponentData()
