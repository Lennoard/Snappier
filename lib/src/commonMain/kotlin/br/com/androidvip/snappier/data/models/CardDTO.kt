package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Card
import kotlinx.serialization.Serializable

@Serializable
data class CardDTO(
    override val content: ContentDTO = ContentDTO(),
    override val backgroundColor: String = "",
    override val shadow: ShadowDTO? = null,
    override val stroke: StrokeDTO? = null,
    override val border: BorderDTO? = null,
    override val events: List<EventDTO> = emptyList(),
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : Card
