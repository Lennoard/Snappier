package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Image
import kotlinx.serialization.Serializable

@Serializable
data class ImageDTO(
    override val url: String = "",
    override val description: String? = null,
    override val resourceName: String? = null,
    override val scaleType: String? = null,
    override val events: List<EventDTO> = emptyList(),
    override val border: BorderDTO? = null,
    override val stroke: StrokeDTO? = null,
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : Image
