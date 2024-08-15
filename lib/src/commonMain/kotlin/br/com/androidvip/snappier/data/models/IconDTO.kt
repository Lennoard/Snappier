package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Icon
import kotlinx.serialization.Serializable

@Serializable
data class IconDTO(
    override val token: String = "",
    override val size: Float = 24F,
    override val color: String = "#000000",
    override val events: List<EventDTO> = emptyList(),
    override val description: String? = null,
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : Icon
