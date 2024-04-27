package br.com.androidvip.snappier.ui.component.data

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event

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
