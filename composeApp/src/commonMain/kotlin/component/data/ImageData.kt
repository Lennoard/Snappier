package component.data

import component.base.Constraints
import component.base.Event

data class ImageData(
    val url: String,
    val description: String,
    val resourceName: String? = null,
    val scaleType: String,
    val events: List<Event> = emptyList(),
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
