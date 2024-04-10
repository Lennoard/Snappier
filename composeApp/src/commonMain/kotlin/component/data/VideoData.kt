package component.data

import component.base.Constraints
import component.base.Event

data class VideoData(
    val url: String,
    val description: String,
    val resourceName: String? = null,
    val autoPlay: Boolean = false,
    val hideControls: Boolean = false,
    val events: List<Event> = emptyList(),
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
