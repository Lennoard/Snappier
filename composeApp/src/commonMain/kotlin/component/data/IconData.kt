package component.data

import component.base.Event

data class IconData(
    val size: Float,
    val token: String,
    val color: String,
    override val alignment: String? = null,
    override val events: List<Event> = emptyList(),
) : BaseComponentData()
