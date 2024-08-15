package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Video
import kotlinx.serialization.Serializable

@Serializable
data class VideoDTO(
    override val url: String = "",
    override val description: String? = null,
    override val resourceName: String? = null,
    override val autoPlay: Boolean = false,
    override val hideControls: Boolean = false,
    override val events: List<EventDTO> = emptyList(),
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : Video
