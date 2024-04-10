package component.data

import component.base.Constraints
import component.base.Event

data class ImageData(
    val url: String = "",
    val description: String? = null,
    val resourceName: String? = null,
    val scaleType: String? = null,
    val events: List<Event> = emptyList(),
    val border: BorderData? = null,
    val stroke: StrokeData? = null,
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
