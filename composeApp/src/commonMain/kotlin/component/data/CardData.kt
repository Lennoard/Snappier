package component.data

import component.base.Constraints
import component.base.Content
import component.base.Event

data class CardData(
    val content: Content,
    val shadow: ShadowData?,
    val stroke: StrokeData?,
    val border: BorderData?,
    override val constraints: Constraints? = null,
    override val alignment: String? = null,
    override val events: List<Event> = emptyList(),
) : BaseComponentData()
