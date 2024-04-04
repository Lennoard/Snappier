package component.data

import component.base.Constraints
import component.base.Event

data class ButtonData(
    val color: String,
    val backgroundColor: String,
    val title: String,
    val border: BorderData? = null,
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    override val constraints: Constraints? = null,
    override val alignment: String? = null,
    override val events: List<Event> = emptyList(),
) : BaseComponentData()
