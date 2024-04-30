package br.com.androidvip.snappier.domain.component.data

import br.com.androidvip.snappier.domain.component.base.Event

data class VideoData(
    val url: String,
    val description: String,
    val resourceName: String?,
    val autoPlay: Boolean,
    val hideControls: Boolean,
    val events: List<Event> = emptyList()
) : BaseComponentData()
