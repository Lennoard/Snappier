package component.data

import component.base.Event

data class IconData(
    val size: Float,
    val token: String,
    val color: String,
    val events: List<Event> = emptyList(),
    override val alignment: String? = null
) : BaseComponentData()
