package component.data

import component.base.Constraints
import component.base.Content
import component.base.Event

data class CardData(
    val content: Content,
    val backgroundColor: String = "",
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    val border: BorderData? = null,
    val events: List<Event> = emptyList(),
    override val alignment: String? = null,
    override val constraints: Constraints? = null
) : BaseComponentData()
