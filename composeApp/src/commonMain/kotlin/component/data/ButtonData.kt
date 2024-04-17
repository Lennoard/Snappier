package component.data

import component.base.Constraints
import component.base.Event

data class ButtonData(
    val color: String = "#000000",
    val backgroundColor: String = "",
    val title: String = "",
    val border: BorderData? = null,
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    val events: List<Event> = emptyList(),
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
