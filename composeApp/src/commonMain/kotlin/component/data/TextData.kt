package component.data

import component.base.Constraints
import component.base.Event

data class TextData(
    val text: String,
    val color: String,
    val size: Float,
    override val constraints: Constraints? = null,
    override val alignment: String? = null,
    override val events: List<Event> = emptyList(),
) : BaseComponentData()
